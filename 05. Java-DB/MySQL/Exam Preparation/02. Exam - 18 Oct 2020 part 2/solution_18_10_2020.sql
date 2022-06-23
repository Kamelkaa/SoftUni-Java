-- 02 -- Insert
INSERT INTO products_stores (product_id ,store_id )
SELECT id,1
FROM products
WHERE id NOT IN (SELECT product_id FROM products_stores);


-- 03 -- Update
UPDATE employees
SET `manager_id` = 3,
	`salary` = `salary` - 500
WHERE year(`hire_date`) > 2003
	AND `store_id` NOT IN (5, 14);
    
    
-- 04 -- Delete
DELETE FROM employees
WHERE id != manager_id
	AND manager_id IS NOT NULL
    AND salary >= 6000;


-- 05 -- Employees
 SELECT e.first_name,
	    e.middle_name,
        e.last_name,
        e.salary,
        e.hire_date
 FROM employees AS e
 ORDER BY e.hire_date DESC;
 
 
 -- 06 -- Products with old pictures 
 SELECT p.name AS 'product_name',
	    p.price,
        p.best_before,
        concat(substring(`description`, 1, 10),'...') AS 'short_description',
        pc.url
 FROM products AS p
	JOIN pictures AS pc
		ON p.picture_id = pc.id
 WHERE char_length(p.description) > 100
	AND year(pc.added_on) < 2019
    AND p.price > 20
ORDER BY p.price DESC;


-- 07 -- Counts of products in stores
SELECT s.name,
	   COUNT(ps.product_id) AS 'product_count',
      round(AVG(p.price), 2) AS 'avg'
FROM stores AS s
	LEFT JOIN products_stores ps
		ON s.id = ps.store_id
	LEFT JOIN products AS p
		ON ps.product_id = p.id
GROUP BY s.name
ORDER BY `product_count` DESC, `avg` DESC, s.id; 


-- 8 -- Specific employee
SELECT concat(e.first_name, ' ', e.last_name) AS 'Full_name',
	   s.name AS 'Store_name',
       a.name AS 'address',
       e.salary
FROM employees AS e
	JOIN stores AS s
		ON e.store_id = s.id
	JOIN addresses AS a
		ON s.address_id = a.id
WHERE e.salary < 4000
	AND a.name LIKE '%5%'
    AND char_length(s.name) > 8
    AND e.last_name LIKE '%n';
    

-- 09 -- Find all information of stores
SELECT reverse(s.`name`) AS 'reversed_name',
	   concat(upper(t.`name`), '-', a.`name`) AS 'full_address',
       COUNT(e.first_name) AS 'employees_count'
FROM employees AS e
	JOIN stores AS s
		ON e.store_id = s.id
	JOIN addresses AS a
		ON s.address_id = a.id
	JOIN towns AS t
		ON a.town_id = t.id
GROUP BY s.`name`
ORDER BY `full_address` ASC;


-- 10 -- Find name of top paid employee by store name
DELIMITER ##

CREATE FUNCTION `udf_top_paid_employee_by_store`(store_name VARCHAR(50)) 
RETURNS TEXT
DETERMINISTIC
BEGIN
RETURN (
	SELECT concat(e.first_name,' ', e.middle_name,'. ', e.last_name, ' works in store for ', 2020 - year(e.hire_date), ' years')
	FROM employees AS e
		JOIN stores AS s
			ON e.store_id = s.id
	WHERE `name` = store_name
	ORDER BY e.salary DESC
	LIMIT 1
);
END;
##
DELIMITER ;

SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';
-- Breena S. Hymans works in store for 3 years
SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';
-- Xylina W. Apfelmann works in store for 7 years


-- 11 --
DELIMITER ##

CREATE PROCEDURE `udp_update_product_price` (address_name VARCHAR (50))
BEGIN 
DECLARE incrase INT;
		IF address_name LIKE '0%' THEN SET incrase = 100;
        ELSE SET incrase = 200;
        END IF;
	UPDATE products AS p SET p.price = p.price + incrase
    WHERE p.id IN (
		SELECT ps.product_id
        FROM addresses AS a
			JOIN stores AS s
				ON a.id = s.address_id
			JOIN products_stores AS ps
				ON s.id = ps.store_id
		WHERE a.name = address_name
    );
END;
##

DELIMITER ;

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;
-- Spic And Span All Purpose  	136.53

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;
-- Wine – Ruffino Chianti Classico	221.63

