import pandas as pd
import numpy as np
import os
import sys

train_path1 = 'KaggleDataSet/competitions/competitive-data-science-predict-future-sales/sales_train.csv'
test_path1 = 'KaggleDataSet/competitions/competitive-data-science-predict-future-sales/test.csv'
train_path = os.path.abspath(train_path1)
test_path = os.path.abspath(test_path1)
train_set = pd.read_csv(train_path)
test_path = pd.read_csv(test_path)
# train_set.info()
test_path.info()
