import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# a = np.array([[1, 2], [2, 3]])
# b = np.ones((2, 3), dtype=np.int16)
# print(a)
# print(b)
#
# c = np.arange(6).reshape((2, 3))
# print(c)
# d = np.arange(6).reshape((3, 2))
# print(d)
# print(b * c)         # element multiplication(m*n  m*n)
# print(np.dot(a, b))  # matrix multiplication (m*s  s*n)
#
#
# e = np.random.random((2,4))
# print(e)
#
# f = d     #True
# f = d.copy() #deep copy
# print(f)

# s = pd.Series([1, 3, 6, np.nan, 44, 1])
# print(s)
# 0     1.0
# 1     3.0
# 2     6.0
# 3     NaN
# 4    44.0
# 5     1.0
# dtype: float64
# dates = pd.date_range('20201220', periods=6)
# # print(dates)
# # DatetimeIndex(['2020-12-20', '2020-12-21', '2020-12-22', '2020-12-23',
# #                '2020-12-24'],
# #               dtype='datetime64[ns]', freq='D')
# df = pd.DataFrame(np.random.random((6, 4)), index=dates, columns=['a', 'b', 'c', 'd'])
# print(df)
#
oldData = ([[1, 1, 2, 2], [1, 1, 3, 7],[2,1,4,5], [2, 2, 3, 8], [3, 2, 4, 5]])
newData = pd.DataFrame(oldData, columns=['A', 'B', 'C', 'D'])
print(newData)
#    A  B  C  D
# 0  1  1  2  2
# 1  1  1  3  3
# 2  2  2  3  3
# 3  3  2  4  5
print(newData.groupby(['A', 'B']).sum())
# A B
# 1 1  5  5
# 2 2  3  3
# 3 2  4  5
newGroup = pd.DataFrame(newData.groupby(['A', 'B'])['D'].sum()).reset_index()
print(newGroup)
#    A  B  D
# 0  1  1  5
# 1  2  2  3
# 2  3  2  5
sns.pointplot(x='A',y='B',hue='D',data=newGroup)
plt.show()
