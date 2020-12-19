import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt

# matplotlib inline

grouped = pd.DataFrame(train.groupby(['year', 'month'])['item_cnt_day'].sum().reset_index())
sns.pointplot(x='month', y='item_cnt_day', hue='year', data=grouped)
plt.show()
print('testPoint itemCnt Successfully')