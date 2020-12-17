from datetime import datetime
from loadDataSet import pd, train

train['year'] = pd.to_datetime(train['date']).dt.strftime('%Y')
train['month'] = train.date.apply(lambda x: datetime.strptime(x, '%d.%m.%Y').strftime('%m'))

test = train.head(2)
