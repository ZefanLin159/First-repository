from datetime import datetime
from loadDataSet import pd, train
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt

train['year'] = pd.to_datetime(train['date']).dt.strftime('%Y')
train['month'] = train.date.apply(lambda x: datetime.strptime(x, '%d.%m.%Y').strftime('%m'))

# pd.set_option('display.max_columns', 8)
# print(train.head(2))

# matplotlib inline

grouped = pd.DataFrame(train.groupby(['year', 'month'])['item_cnt_day'].sum().reset_index())
sns.pointplot(x='month', y='item_cnt_day', hue='year', data=grouped)
plt.show()
