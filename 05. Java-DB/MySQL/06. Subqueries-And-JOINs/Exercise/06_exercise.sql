-- soft_uni --
#ex.1 - Employee Address
SELECT e.employee_id,
	e.job_title,
    e.address_id,
    a.address_text
FROM employees AS e
	JOIN addresses AS a
		ON e.address_id = a.address_id
ORDER BY e.address_id
LIMIT 5;


#ex.2 - Addresses with Towns
SELECT e.first_name,
	e.last_name,
    t.name,
    a.address_text
FROM employees AS e
	JOIN addresses AS a
		ON e.address_id = a.address_id
	JOIN towns AS t
		ON a.town_id = t.town_id
ORDER BY e.first_name, e.last_name
LIMIT 5;


#ex.3 - Sales Employee
SELECT e.employee_id,
	   e.first_name,
       e.last_name,
       d.name
FROM employees AS e
	JOIN departments AS d
		ON e.department_id = d.department_id
WHERE d.name = 'Sales'
ORDER BY e.employee_id DESC;


#ex.4 - Employee Departments
SELECT e.employee_id,
	   e.first_name,
       e.salary,
       d.name
FROM employees AS e
	JOIN departments AS d
		ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;


#ex.5 - Employees Without Project
SELECT e.employee_id,
	   e.first_name
FROM employees AS e
	LEFT JOIN employees_projects AS ep
		ON e.employee_id = ep.employee_id
	LEFT JOIN projects AS p
		ON ep.project_id = p.project_id
WHERE p.name IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;


#ex.6 - Employees Hired After
SELECT e.first_name,
	   e.last_name,
       e.hire_date,
       d.name AS 'dept_name'
FROM employees AS e
	JOIN departments AS d
		ON e.department_id = d.department_id
WHERE e.hire_date > DATE('1999-01-01')
	AND d.name IN ('Sales', 'Finance')
ORDER BY e.hire_date;


#ex.7 - Employees with Project
SELECT e.employee_id,
	   e.first_name,
       p.name AS 'project_name'
FROM employees AS e
	JOIN employees_projects AS ep
		ON e.employee_id = ep.employee_id
	JOIN projects AS p
		ON ep.project_id = p.project_id
WHERE DATE(p.start_date) > '2002-08-13'
	AND p.end_date IS NULL
ORDER BY e.first_name ASC, p.name ASC
LIMIT 5;


#ex.8 - Employee 24 
SELECT e.employee_id,
	   e.first_name,
      IF(year(p.start_date) >='2005', NULL, p.name) AS 'project_name'
FROM employees AS e
	JOIN employees_projects AS ep
		ON e.employee_id = ep.employee_id
	JOIN projects AS p
		ON ep.project_id = p.project_id
WHERE e.employee_id = 24
ORDER BY p.name;


#ex.9 - Employee Manager
SELECT e.employee_id,
	   e.first_name,
       e.manager_id,
       m.first_name AS 'manager_name'
FROM employees AS e
	JOIN employees AS m
		ON e.manager_id = m.employee_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name ASC;


#ex.10 - Employee Summary
SELECT e.employee_id,
	   concat(e.first_name, ' ', e.last_name) AS 'employee_name',
       concat(m.first_name, ' ', m.last_name) AS 'manager_name',
       d.name AS 'department_name'
FROM employees AS e
	JOIN employees AS m
		ON e.manager_id = m.employee_id
    JOIN departments AS d
		ON e.department_id = d.department_id
ORDER BY e.employee_id
LIMIT 5;
	

#ex.11 - Min Average Salary
SELECT AVG(e.salary) AS 'min_average_salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY `min_average_salary`
LIMIT 1;


-- geography --
#ex.12 - Highest Peaks in Bulgaria
SELECT c.country_code,
	   m.mountain_range,
       p.peak_name,
       p.elevation
FROM countries AS c
	JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
	JOIN mountains AS m
		ON mc.mountain_id = m.id
	JOIN peaks AS p
		ON m.id = p.mountain_id
WHERE c.country_code = 'BG'
	AND p.elevation > 2835
ORDER BY p.elevation DESC;
	
    
#ex.13 - Count Mountain Ranges
SELECT c.country_code,
	   COUNT(m.mountain_range) AS 'mountain_range'
FROM countries AS c
	JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
	JOIN mountains AS m
		ON mc.mountain_id = m.id
GROUP BY c.country_code
HAVING c.country_code IN ('BG', 'RU', 'US')
ORDER BY `mountain_range` DESC;


#ex.14 - Countries with Rivers
SELECT c.country_name,
	   r.river_name
FROM countries AS c
	LEFT JOIN countries_rivers AS cr
		ON c.country_code = cr.country_code
	LEFT JOIN rivers AS r
		ON cr.river_id = r.id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name ASC
LIMIT 5;


#ex.15 - Continents and Currencies *



#ex.16 - Countries without any Mountains
SELECT COUNT(*) AS 'country_count'
FROM countries AS c
	LEFT JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
WHERE mc.mountain_id IS NULL;


#ex.17 - Highest Peak and Longest River by Country
SELECT c.country_name,
	   MAX(p.elevation) AS 'highest_peak_elevation',
	   MAX(r.length) AS 'longest_river_length'
FROM countries AS c
	LEFT JOIN mountains_countries AS mc
		ON c.country_code = mc.country_code
	LEFT JOIN mountains AS m
		ON mc.mountain_id = m.id
	JOIN peaks AS p
		ON m.id = p.mountain_id
	LEFT JOIN countries_rivers AS cr
		ON c.country_code = cr.country_code
	LEFT JOIN rivers AS r
		ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC, c.country_name
LIMIT 5;
