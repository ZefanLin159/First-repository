import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt, test

ts = train.groupby(["date_block_num"])["item_cnt_day"].sum()  # 每月的总销售量
ts.astype('float')
plt.figure(figsize=(10, 5))
plt.title('Total Sales of the whole time period')
plt.xlabel('Time')
plt.ylabel('Sales')
plt.plot(ts)  # 折线图
# plt.show()
# print('testing TotalSale')

# train.item_cnt_day.hist(bins=100)
train.item_cnt_day.hist(bins=20, figsize=(5, 5))  # ???这个直方图是为了表示什么
print(train.item_cnt_day.describe())
# plt.show()

# print('Data set size before remove item price 0 cleaning:', train.shape)
# 滤除价格小于等于0的样本
train = train.query('item_price > 0')
print('Data set size after remove item price 0 cleaning:', train.shape)

#skip
# print('Data set size before filter valid:', train.shape)
# Only shops that exist in test set.
train = train[train['shop_id'].isin(test['shop_id'].unique())]
# Only items that exist in test set.
train = train[train['item_id'].isin(test['item_id'].unique())]
print('Data set size after filter valid:', train.shape)

# print('Data set size before remove outliers:', train.shape)
train = train.query('item_cnt_day >= 0 and item_cnt_day <= 125 and item_price < 75000')
print('Data set size after remove outliers:', train.shape)
