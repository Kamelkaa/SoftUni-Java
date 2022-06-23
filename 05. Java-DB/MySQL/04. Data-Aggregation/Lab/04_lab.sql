#ex.1 - Departments Info
SELECT e.department_id, COUNT(e.department_id) AS 'Number of employees'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id, `Number of employees`;


#ex.2 - Average Salary
SELECT e.department_id, round(AVG(e.salary), 2) AS 'Average Salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id;


#ex.3 - Minimum Salary
SELECT e.department_id, round(MIN(e.salary), 2) AS 'Min Salary'
FROM employees AS e
GROUP BY e.department_id
HAVING `Min Salary` > 800
ORDER BY e.department_id;


#ex.4 - Appetizers Count
SELECT COUNT(*)
FROM products
WHERE price > 8
GROUP BY category_id
HAVING category_id = 2;

SELECT COUNT(id)   -- 2 --
FROM products
WHERE category_id = 2 AND price > 8;

#ex.5 - Menu Prices
SELECT p.category_id, 
       round(AVG(p.price), 2) AS 'Average Price',
       round(MIN(p.price), 2) AS 'Cheapest Product',
       round(MAX(p.price), 2) AS 'Most Expensive Product'
FROM products AS p
GROUP BY p.category_id;