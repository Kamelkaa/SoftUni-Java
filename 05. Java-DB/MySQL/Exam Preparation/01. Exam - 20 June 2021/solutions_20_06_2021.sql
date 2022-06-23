-- 2 -- Insert
INSERT INTO clients(full_name, phone_number)
(SELECT concat(d.first_name, ' ', d.last_name), concat('(088) 9999', d.id*2)
 FROM drivers AS d
 WHERE d.id BETWEEN 10 AND 20);


-- 3 -- Update
SET SQL_SAFE_UPDATES = 0;

UPDATE cars
SET `condition` = 'C'
WHERE `mileage` >= 800000 OR `mileage` IS NULL
	AND `year` <= 2010
    AND `make` != 'Mercedes-Benz';


-- 4 -- Delete
DELETE FROM clients
WHERE id NOT IN(SELECT client_id 
				FROM courses)
	AND char_length(clients.full_name) > 3;
    

-- 5 --  Cars
SELECT c.make,
	   c.model,
       c.condition
FROM cars AS c
ORDER BY c.id;


-- 6 -- Drivers and Cars
SELECT d.first_name,
	   d.last_name,
       c.make,
       c.model,
       c.mileage
FROM drivers AS d
	JOIN cars_drivers AS cd
		ON d.id = cd.driver_id
	JOIN cars AS c
		ON cd.car_id = c.id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC,
		 d.first_name;
         

-- 7 -- Number of courses 
SELECT c.id AS 'car_id',
	   c.make,
       c.mileage,
       COUNT(cr.car_id) AS 'count_of_courses',
       round(AVG(cr.bill), 2) AS 'avg_bill'
FROM cars AS c
	LEFT JOIN courses AS cr
		ON c.id = cr.car_id
GROUP BY c.id
HAVING `count_of_courses` != 2
ORDER BY `count_of_courses` DESC, c.id;


-- 8 -- Regular clients
SELECT c.full_name,
	   count(cr.car_id) AS 'count_of_cars',
       SUM(cr.bill) AS 'total_sum'
FROM clients AS c
	JOIN courses AS cr
     ON c.id = cr.client_id
GROUP BY c.full_name
HAVING c.full_name LIKE '_a%' AND `count_of_cars` > 1
ORDER BY c.full_name;


-- 9 -- Full info for courses
SELECT ad.name,
	   IF( hour(c.start) BETWEEN 6 AND 20, 'Day', 'Night') AS 'day_time',
	   c.bill,
       cl.full_name,
       cr.make,
       cr.model,
       cg.name AS 'category_name'
FROM addresses AS ad
	JOIN courses AS c
		ON c.from_address_id = ad.id
	JOIN clients AS cl
		ON c.client_id = cl.id
	JOIN cars AS cr
		ON c.car_id = cr.id
	JOIN categories AS cg
		ON cr.category_id = cg.id
ORDER BY c.id;


-- 10 -- Find all courses by client’s phone number
DELIMITER ##

CREATE FUNCTION `udf_courses_by_client` (phone_num VARCHAR (20))
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (
	SELECT count(c.client_id)
	FROM courses AS c
		JOIN clients AS cl
			ON c.client_id = cl.id 
	WHERE cl.phone_number = phone_num
);
END
##
DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`; -- 5
SELECT udf_courses_by_client ('(831) 1391236') as `count`; -- 3
SELECT udf_courses_by_client ('(704) 2502909') as `count`; -- 0



-- 11 -- Full info for address
DELIMITER ##

CREATE PROCEDURE `udp_courses_by_address` (address_name VARCHAR(100))
BEGIN
	SELECT ad.name,
		   cl.full_name,
		   CASE
				WHEN c.bill <= 20 THEN 'Low'
				WHEN c.bill BETWEEN 21 AND 30 THEN 'Medium'
				ELSE 'High'
		   END AS 'level_of_bill',
		   cr.make,
		   cr.`condition`,
		   cg.`name` AS 'cat_name'
	FROM addresses AS ad
		JOIN courses AS c
			ON c.from_address_id = ad.id
		JOIN clients AS cl
			ON c.client_id = cl.id
		JOIN cars AS cr
			ON c.car_id = cr.id
		JOIN categories AS cg
			ON cr.category_id = cg.id
	WHERE ad.name = address_name
	ORDER BY cr.make, cl.full_name;
END;
##

DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');
CALL udp_courses_by_address('66 Thompson Drive');
