import pandas as pd
import os
import sys
from datetime import datetime
import matplotlib.pyplot as plt

path = 'KaggleDataSet/competitions/competitive-data-science-predict-future-sales/'

item_categories_path = os.path.abspath(path + 'item_categories.csv')
items_path = os.path.abspath(path + 'items.csv')
train_path = os.path.abspath(path + 'sales_train.csv')
sample_path = os.path.abspath(path + 'sample_submission.csv')
shops_path = os.path.abspath(path + 'shops.csv')
test_path = os.path.abspath(path + 'test.csv')

item_cats = pd.read_csv(item_categories_path)
items = pd.read_csv(items_path)
train = pd.read_csv(train_path)
sample = pd.read_csv(sample_path)
shops = pd.read_csv(shops_path)
test = pd.read_csv(test_path)

# item_cats.info()
# items.info()
# train.info()
# sample.info()
# shops.info()
# test.info()
# print("loadDataSuccessfully\n")


train['year'] = pd.to_datetime(train['date']).dt.strftime('%Y')
train['month'] = train.date.apply(lambda x: datetime.strptime(x, '%d.%m.%Y').strftime('%m'))

# pd.set_option('display.max_columns', 8)
# print(train.head(2))
