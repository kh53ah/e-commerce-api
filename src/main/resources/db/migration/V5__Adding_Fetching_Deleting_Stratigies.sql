ALTER TABLE user_profiles ADD CONSTRAINT user_profiles_id_fkey
FOREIGN KEY (id) REFERENCES users(id)
ON DELETE CASCADE;

ALTER TABLE wishlists ADD CONSTRAINT wishlists_user_id_fkey
FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE orders ADD CONSTRAINT orders_user_id_fkey
FOREIGN KEY (user_id) REFERENCES users(id)
ON DELETE RESTRICT;

ALTER TABLE products DROP CONSTRAINT products_category_id_fkey;
ALTER TABLE products ADD CONSTRAINT products_category_id_fkey
FOREIGN KEY (category_id) REFERENCES categories(id)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE order_items DROP CONSTRAINT order_items_product_id_fkey;
ALTER TABLE order_items ADD CONSTRAINT order_items_product_id_fkey
FOREIGN KEY (product_id) REFERENCES products(id)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE tags_products
DROP CONSTRAINT IF EXISTS tags_products_product_id_fkey,
DROP CONSTRAINT IF EXISTS tags_products_tag_id_fkey;

ALTER TABLE tags_products ADD CONSTRAINT tags_products_product_id_fkey
FOREIGN KEY (product_id) REFERENCES products(id)
ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT tags_products_tag_id_fkey
FOREIGN KEY (tag_id) REFERENCES tags(id)
ON UPDATE CASCADE ON DELETE CASCADE;