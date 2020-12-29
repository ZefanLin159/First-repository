from totalSale import train, test, pd, np


# groupby(['A','B'])['C'].sum(),取出['A','B']组成新表格对C求和，
# 然后reset_index():原先第一列前面重新加索引得到新表格（这里会保留原先的一列）
# Aggregate to monthly level the sales 按月计算销售额
monthly_sales_train = train.groupby(["date_block_num", "shop_id", "item_id"])[
    "date_block_num", "date", "item_price", "item_cnt_day"].agg(
    {"date_block_num": 'mean', "date": ["min", 'max'], "item_price": "mean", "item_cnt_day": "sum"})

print(monthly_sales_train.head(5))

sales_data_flat = monthly_sales_train.item_cnt_day.apply(list).reset_index()
# Keep only the test data of valid
sales_data_flat = pd.merge(test, sales_data_flat, on=['item_id', 'shop_id'], how='left')
# fill na with 0
sales_data_flat.fillna(0, inplace=True)
sales_data_flat.drop(['shop_id', 'item_id'], inplace=True, axis=1)
print(sales_data_flat.head(10))


# We will create pivot table.
# Rows = each shop+item code
# Columns will be out time sequence
pivoted_sales = sales_data_flat.pivot_table(index='ID', columns='date_block_num', fill_value=0, aggfunc='sum')
print(pivoted_sales.head(10))

# X we will keep all columns execpt the last one
X_train = np.expand_dims(pivoted_sales.values[:, :-1], axis=2)
# the last column is our prediction
y_train = pivoted_sales.values[:, -1:]

# for test we keep all the columns execpt the first one
X_test = np.expand_dims(pivoted_sales.values[:, 1:], axis=2)

# lets have a look on the shape
print(X_train.shape, y_train.shape, X_test.shape)
