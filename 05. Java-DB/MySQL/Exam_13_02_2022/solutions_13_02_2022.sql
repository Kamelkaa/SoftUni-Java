-- 02 -- Insert 
INSERT INTO reviews(content, picture_url, published_at, rating)
SELECT substring(p.description, 1, 15),
	   reverse(p.name),
       '2010-10-10',
       p.price / 8
FROM products AS p
WHERE p.id >= 5;

-- 03 -- Update
SET SQL_SAFE_UPDATES = 0;

UPDATE products AS p
SET p.quantity_in_stock = p.quantity_in_stock - 5
WHERE p.quantity_in_stock BETWEEN 60 AND 70;


UPDATE products as p
SET	p.`quantity_in_stock` = p.`quantity_in_stock`-5
WHERE p.`quantity_in_stock`>=60 and p.`quantity_in_stock`<70;
-- 04 -- 
DELETE cus
FROM customers AS cus
	LEFT JOIN orders AS o
		ON cus.id = o.customer_id
WHERE o.customer_id IS NULL;


-- 05 -- Categories
SELECT cat.id,
	   cat.name
FROM categories AS cat
ORDER BY cat.name DESC;


-- 06 -- Quantity 
SELECT p.id,
	   p.brand_id,
       p.name,
       p.quantity_in_stock
FROM products AS p
WHERE p.price > 1000
	AND p.quantity_in_stock < 30
ORDER BY p.quantity_in_stock ASC, p.id ASC;


-- 07 -- Review
SELECT *
FROM reviews AS rev
WHERE rev.content LIKE 'My%'
	AND char_length(rev.content) > 61
ORDER BY rev.rating DESC;

-- 08 -- First customers
SELECT concat(cus.first_name, ' ', cus.last_name) AS 'full_name',
	   cus.address AS 'address',
       o.order_datetime AS 'order_date'
FROM customers AS cus
	JOIN orders AS o
		ON cus.id = o.customer_id
WHERE year(o.order_datetime) <= '2018'
ORDER BY `full_name` DESC;


-- 09 -- Best categories
SELECT COUNT(p.id) AS 'items_count',
	   cat.name,
       SUM(p.quantity_in_stock) AS 'total_quantity'
FROM categories AS cat
	LEFT JOIN products AS p
		ON cat.id = p.category_id
GROUP BY cat.id
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;


-- 10 -- Extract client cards count
DELIMITER ##

CREATE FUNCTION `udf_customer_products_count`(name VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
	SELECT COUNT(p.id)
	FROM customers AS cus
		JOIN orders AS o
			ON cus.id = o.customer_id
		JOIN orders_products AS op
			ON o.id = op.order_id
		JOIN products AS p
			ON op.product_id = p.id
	WHERE cus.first_name = name
	GROUP BY cus.id	
 );
END;
##
DELIMITER ;

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';


-- 11 -- Reduce price
DELIMITER ##

CREATE PROCEDURE `udp_reduce_price` (category_name VARCHAR(50))
BEGIN 
DECLARE new_price DECIMAL(19, 2);
	UPDATE products AS p
		JOIN categories AS cat
			ON p.category_id = cat.id
		JOIN reviews AS rev
			ON p.review_id = rev.id
	SET	p.price = p.price - (p.price* 0.30)
	WHERE rev.rating < 4 AND cat.name = category_name;

END;
##

DELIMITER ;	

DROP PROCEDURE udp_reduce_price;
CALL udp_reduce_price ('Phones and tablets');