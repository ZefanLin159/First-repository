import pandas as pd
import os
import sys
from datetime import datetime
import matplotlib.pyplot as plt

pd.set_option('display.width', 1000)  # 增加每行的宽度
pd.set_option('display.max_rows', 100)  # 取消行限制
pd.set_option('display.max_columns', 100)  # 取消列限制
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

# ID- 代表测试集中的（商店，商品）元组的ID
# shop_id-商店的唯一标识符
# item_id-产品的唯一标识符
# item_category_id-项目类别的唯一标识符
# item_cnt_day-销售的产品数量。您正在预测此量度的每月金额
# item_price-商品的当前价格
# 日期 -格式为dd / mm / yyyy的日期
# date_block_num-连续的月份号，为方便起见。2013年1月为0,2013年2月为1，...，2015年10月为33
# item_name- 项目名称
# shop_name-商店名称
# item_category_name-项目类别名称

# item_cats.info()
# items.info()
# train.info()
# sample.info()
# shops.info()
# test.info()
# print("loadDataSuccessfully\n")

train['year'] = pd.to_datetime(train['date']).dt.strftime('%Y')  # 增加年份列
train['month'] = train.date.apply(lambda x: datetime.strptime(x, '%d.%m.%Y').strftime('%m'))  # 增加月份列
# pd.set_option('display.max_rows', 10, 'display.max_columns', 10)
# print(train.head(5))

# now =datetime.now()
# print(now.strftime('%Y-%m-%d'))
# print(now.strftime('%H:%M:%S'))
