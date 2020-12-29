import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt

# matplotlib inline

# dataFrame给表格
# groupby(['A','B'])['C'].sum(),取出['A','B']组成新表格对C求和，
# 然后reset_index():原先第一列前面重新加索引得到新表格（这里会保留原先的一列）

grouped = pd.DataFrame(train.groupby(['year', 'month'])['item_cnt_day'].sum().reset_index())
sns.pointplot(x='month', y='item_cnt_day', hue='year', data=grouped)
# 横坐标x，纵坐标y，hue是散点（相等的会连起来）data是数据来源，横坐标纵坐标的名称要与data中的名称对应好，否则报错（散点图）
plt.show()
print('testPoint itemCnt Successfully')
