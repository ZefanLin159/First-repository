import numpy as np
import seaborn as sns
from loadDataSet import pd, train, plt

# Price
grouped_price = pd.DataFrame(train.groupby(['year', 'month'])['item_price'].mean().reset_index())
sns.pointplot(x='month', y='item_price', hue='year', data=grouped_price)
plt.show()
print("test")
