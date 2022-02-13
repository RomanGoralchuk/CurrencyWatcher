CREATE TABLE crypto_currency (
currency_id BIGINT NOT NULL,
symbol VARCHAR(10) NOT NULL,
price_usd DOUBLE(40,2) NULL DEFAULT NULL,
PRIMARY KEY (currency_id)
);