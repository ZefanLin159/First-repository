from totalSale import train, test, pd

# Aggregate to monthly level the sales
monthly_sales_train = train.groupby(["date_block_num", "shop_id", "item_id"])[
    "date_block_num", "date", "item_price", "item_cnt_day"].agg(
    {"date_block_num": 'mean', "date": ["min", 'max'], "item_price": "mean", "item_cnt_day": "sum"})

print(monthly_sales_train.head(5))

# sales_data_flat = monthly_sales_train.item_cnt_day.apply(list).reset_index()
# # Keep only the test data of valid
# sales_data_flat = pd.merge(test, sales_data_flat, on=['item_id', 'shop_id'], how='left')
# # fill na with 0
# sales_data_flat.fillna(0, inplace=True)
# sales_data_flat.drop(['shop_id', 'item_id'], inplace=True, axis=1)
# sales_data_flat.head(20)
