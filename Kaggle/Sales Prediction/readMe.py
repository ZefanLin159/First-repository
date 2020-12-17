import pandas as pd
import numpy as np
import os
import sys

# getcwd F:\work\Kaggle\Sales Prediction
# sysargv ['F:/work/Kaggle/Sales Prediction/main.py']
# realpath F:\work\Kaggle\Sales Prediction\main.py
# realpath.split F:\work\Kaggle\Sales Prediction
# __file__ F:/work/Kaggle/Sales Prediction/main.py
# __file__.dir F:/work/Kaggle/Sales Prediction

print('getcwd',os.getcwd())
print('sysargv', sys.argv)
print('realpath', os.path.realpath(sys.argv[0]))
print('realpath.split', os.path.split(os.path.realpath(sys.argv[0]))[0])
print('__file__', __file__)
print('__file__.dir', os.path.dirname(__file__))
