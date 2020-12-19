import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt

ts = train.groupby(["date_block_num"])["item_cnt_day"].sum()
ts.astype('float')
plt.figure(figsize=(16, 8))
plt.title('Total Sales of the whole time period')
plt.xlabel('Time')
plt.ylabel('Sales')
plt.plot(ts)
# plt.show()
print('testing TotalSale')

train.item_cnt_day.hist(bins=100)
# print(train.item_cnt_day.describe())
# plt.show()

print('Data set size before remove item price 0 cleaning:', train.shape)
#filter price
train = train.query('item_price > 0')
print('Data set size after remove item price 0 cleaning:', train.shape)
