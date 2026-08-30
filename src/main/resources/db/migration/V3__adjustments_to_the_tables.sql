ALTER TABLE products
ALTER COLUMN price TYPE DECIMAL(10,2);

ALTER TABLE orders
DROP CONSTRAINT orders_status_check;

ALTER TABLE orders
ADD CONSTRAINT chk_order_status
CHECK (status IN ('PREPARED', 'IN_DELIVERY', 'DELIVERED'));

CREATE TABLE tags_products(
product_id INT REFERENCES products(id),
tag_id INT REFERENCES tags(id),
PRIMARY KEY (product_id, tag_id));

CREATE TABLE wishList(
product_id INT REFERENCES products(id),
user_id BIGINT REFERENCES users(id));