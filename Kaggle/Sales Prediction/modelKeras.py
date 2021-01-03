from monthSales import X_train, y_train, X_test, pd, test
from tensorflow.python.keras.layers import LSTM, Dense, Dropout
from tensorflow.python.keras.models import Sequential
from tensorflow.python.keras.models import load_model, Model
print('test')
# our defining sales model
sales_model = Sequential()
sales_model.add(LSTM(units=64, input_shape=(33, 1)))
sales_model.add(Dropout(0.5))
sales_model.add(Dense(1))

sales_model.compile(loss='mse', optimizer='adam', metrics=['mean_squared_error'])
sales_model.summary()

sales_model.fit(X_train, y_train, batch_size=4096, epochs=100)

submission_output = sales_model.predict(X_test)
submission = pd.DataFrame({'ID': test['ID'], 'item_cnt_month': submission_output.ravel()})

submission.to_csv('submission_stacked.csv', index=False)
print(submission.head())
