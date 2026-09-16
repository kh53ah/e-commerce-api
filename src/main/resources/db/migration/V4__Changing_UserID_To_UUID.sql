ALTER TABLE user_profiles DROP CONSTRAINT user_profiles_id_fkey;
ALTER TABLE orders DROP CONSTRAINT orders_user_id_fkey;
ALTER TABLE wishlists DROP CONSTRAINT wishlists_user_id_fkey;

ALTER TABLE users
ALTER COLUMN id DROP IDENTITY IF EXISTS;

ALTER TABLE users
ALTER COLUMN id TYPE UUID USING gen_random_uuid(),
ALTER COLUMN id SET DEFAULT gen_random_uuid();

ALTER TABLE user_profiles DROP COLUMN id;
ALTER TABLE user_profiles ADD COLUMN id UUID PRIMARY KEY;

ALTER TABLE orders DROP COLUMN user_id;
ALTER TABLE orders ADD COLUMN user_id UUID;

ALTER TABLE wishlists DROP COLUMN user_id;
ALTER TABLE wishlists ADD COLUMN user_id UUID NOT NULL;