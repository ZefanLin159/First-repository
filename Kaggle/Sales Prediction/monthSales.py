from totalSale import train, test, pd, np

# groupby(['A','B'])['C'].sum(),取出['A','B']组成新表格对C求和，
# 然后reset_index():原先第一列前面重新加索引得到新表格（这里会保留原先的一列）
# Aggregate to monthly level the sales 按月计算销售额
monthly_sales_train = train.groupby(["date_block_num", "shop_id", "item_id"])[
    "date_block_num", "date", "item_price", "item_cnt_day"].agg(
    {"date_block_num": 'mean', "date": ["min", 'max'], "item_price": "mean", "item_cnt_day": "sum"})

print(monthly_sales_train.head(5))
# print('\n')

# 将item_cnt_day列表化并重新进行索引
sales_data_flat = monthly_sales_train.item_cnt_day.apply(list).reset_index()
# print(sales_data_flat.head(5))
# print('\n')
# 只保留有效的测试练数据（测试集所有列留下，on是两个数据集中共有的列。 how='left' 左连接，将左边表格留下，把右边表格的列接上，右边在左边没有的值显示NAN）
sales_data_flat = pd.merge(test, sales_data_flat, on=['item_id', 'shop_id'], how='left')
# na值补上0，inplace=True 在原对象上进行修改
sales_data_flat.fillna(0, inplace=True)
# 删除['shop_id', 'item_id']列
sales_data_flat.drop(['shop_id', 'item_id'], inplace=True, axis=1)
# ID date_block_num sum
print(sales_data_flat.head(5))
# print('\n')

# 创建数据透视表.
# 行=每个商店+物品代码
# 列将按时间顺序输出
# 'ID'是测试集中某一商店卖的某一产品
pivoted_sales = sales_data_flat.pivot_table(index='ID', columns='date_block_num', fill_value=0, aggfunc='sum')
print(pivoted_sales.head(10))
print('\n')

# 我们将保留除最后一列以外的所有列，并增加厚度
X_train = np.expand_dims(pivoted_sales.values[:, :-1], axis=2)
# 最后一列作为测试集
y_train = pivoted_sales.values[:, -1:]
# 我们保留了除第一个列以外的所有列方便测试
X_test = np.expand_dims(pivoted_sales.values[:, 1:], axis=2)

# lets have a look on the shape
print(X_train.shape, y_train.shape, X_test.shape)
# (214200, 33, 1) (214200, 1) (214200, 33, 1)
