-- Drop existing table and its sequence if they exist
DROP TABLE IF EXISTS product;
DROP SEQUENCE IF EXISTS product_id_seq;

-- Create sequence
CREATE SEQUENCE product_id_seq;

-- Create table with sequence
CREATE TABLE product (
                         id BIGINT PRIMARY KEY DEFAULT nextval('product_id_seq'),
                         description TEXT NOT NULL,
                         price DECIMAL(10,2) NOT NULL,
                         quantity_available INTEGER NOT NULL DEFAULT 0
);

-- Give ownership of sequence to the id column
ALTER SEQUENCE product_id_seq OWNED BY product.id;

-- insert
-- INSERT INTO product (id, description, price, quantity_available)
-- VALUES (1, 'Product2', 1297, 69);