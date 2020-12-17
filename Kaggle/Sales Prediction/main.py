from datetime import datetime
from loadDataSet import pd, train

train['year'] = pd.to_datetime(train['date']).dt.strftime('%Y')
train['month'] = train.date.apply(lambda x: datetime.strptime(x, '%d.%m.%Y').strftime('%m'))

pd.set_option('display.max_columns', 8)
print(train.head(2))
