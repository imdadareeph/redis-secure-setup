DROP TABLE IF EXISTS product;

CREATE TABLE product (
                         id BIGSERIAL PRIMARY KEY,
                         description TEXT NOT NULL,
                         price DECIMAL(10,2) NOT NULL,
                         quantity_available INTEGER NOT NULL DEFAULT 0
);

INSERT INTO product (id, description, price, quantity_available)
VALUES (2, 'Product2', 1297, 69);