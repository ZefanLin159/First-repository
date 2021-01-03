import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt, test

ts = train.groupby(["date_block_num"])["item_cnt_day"].sum()  # 每月的总销售量
ts.astype('float')
plt.figure(figsize=(10, 5))  # 尺寸
plt.title('Total Sales of the whole time period')
plt.xlabel('Time')
plt.ylabel('Sales')
plt.plot(ts)  # 折线图
# plt.show()
# print('testing TotalSale')

# train.item_cnt_day.hist(bins=100)
# train.item_cnt_day.hist(bins=20, figsize=(5, 5))  # ???这个直方图是为了表示什么
# print(train.item_cnt_day.describe())
# plt.show()
# skip


# 滤除价格小于等于0的样本
train = train.query('item_price > 0')
# 留下测试集中test_id不重复的元素，并返回一个新的无元素重复的元组或者列表
# 训练集留下和测试集中商品ID，商店ID相同的数据。（滤除测试集中没有的商品和商店）
train = train[train['shop_id'].isin(test['shop_id'].unique())]
# Only items that exist in test set.
train = train[train['item_id'].isin(test['item_id'].unique())]
# print('Data set size after filter valid:', train.shape)

# 移除异常/错误值，留下正常的值
train = train.query('item_cnt_day >= 0 and item_cnt_day <= 125 and item_price < 75000')
print('Data set size after remove outliers:', train.shape)
# print('train is\n', train.head(10))
