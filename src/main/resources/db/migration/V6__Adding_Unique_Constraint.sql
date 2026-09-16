ALTER TABLE categories
ADD CONSTRAINT uq_categories_name UNIQUE (name);

ALTER TABLE products
ADD CONSTRAINT uq_products_name UNIQUE (name);

ALTER TABLE tags
ADD CONSTRAINT uq_tags_name UNIQUE (name);

ALTER TABLE users
ADD CONSTRAINT uq_users_username UNIQUE (username),
ADD CONSTRAINT uq_users_email UNIQUE (email);