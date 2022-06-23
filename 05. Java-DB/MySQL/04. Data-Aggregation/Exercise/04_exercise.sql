-- gringotts --
#ex.1 - Records’ Count
SELECT COUNT(*) AS 'count'
FROM wizzard_deposits;


#ex.2 - Longest Magic Wand
SELECT max(wd.magic_wand_size) AS 'longest_magic_wand'
FROM wizzard_deposits AS wd;


#ex.3 - Longest Magic Wand per Deposit Groups
SELECT wd.deposit_group, 
       MAX(wd.magic_wand_size) AS 'longest_magic_wand'
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY `longest_magic_wand`, wd.deposit_group;


#ex.4 - Smallest Deposit Group per Magic Wand Size*
SELECT wd.deposit_group
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY AVG(wd.magic_wand_size) LIMIT 1;


#ex.5 -  Deposits Sum
SELECT wd.deposit_group,
	   sum(wd.deposit_amount) AS 'total_sum'
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group
ORDER BY `total_sum`;


#ex.6 - Deposits Sum for Ollivander Family
SELECT wd.deposit_group,
	   sum(wd.deposit_amount) AS 'total_sum'
FROM wizzard_deposits AS wd
WHERE wd.magic_wand_creator = 'Ollivander family'
GROUP BY wd.deposit_group
ORDER BY wd.deposit_group;


#ex.7 - Deposits Filter
SELECT wd.deposit_group,
	   sum(wd.deposit_amount) AS 'total_sum'
FROM wizzard_deposits AS wd
WHERE wd.magic_wand_creator = 'Ollivander family'
GROUP BY wd.deposit_group
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;


#ex.8 - Deposit Charge
SELECT wd.deposit_group,
	   wd.magic_wand_creator,
       min(wd.deposit_charge) AS 'min_deposit_charge'
FROM wizzard_deposits AS wd
GROUP BY wd.deposit_group, wd.magic_wand_creator
ORDER BY wd.magic_wand_creator, wd.deposit_group;


#ex.9 - Age Groups
SELECT 
	CASE
		WHEN wd.age BETWEEN 0 AND 10 THEN '[0-10]'
		WHEN wd.age BETWEEN 11 AND 20 THEN '[11-20]'
		WHEN wd.age BETWEEN 21 AND 30 THEN '[21-30]'
		WHEN wd.age BETWEEN 31 AND 40 THEN '[31-40]'
		WHEN wd.age BETWEEN 41 AND 50 THEN '[41-50]'
		WHEN wd.age BETWEEN 51 AND 60 THEN '[51-60]'
		WHEN wd.age > 60 THEN '[61+]'
	END AS 'age_group',
	COUNT(wd.age) AS 'wizard_count'
FROM wizzard_deposits AS wd
GROUP BY `age_group`
ORDER BY `age_group`;


#ex.10 - First Letter
SELECT LEFT(wd.first_name, 1) AS 'first_letter'
FROM wizzard_deposits AS wd
WHERE wd.deposit_group LIKE 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;


#ex.11 - Average Interest
SELECT wd.deposit_group,
       wd.is_deposit_expired,
       avg(wd.deposit_interest) AS 'average_interest'
FROM wizzard_deposits AS wd
WHERE wd.deposit_start_date > '1985-01-01'
GROUP BY wd.deposit_group, wd.is_deposit_expired
ORDER BY wd.deposit_group DESC, wd.is_deposit_expired;


-- soft_uni --
#ex.12 - Employees Minimum Salaries
SELECT e.department_id,
	   MIN(e.salary) AS 'minimum_salary'
FROM employees AS e
WHERE e.hire_date > '2000-01-01 00:00:00.000000'
GROUP BY e.department_id
HAVING e.department_id IN(2, 5, 7)
ORDER BY e.department_id;


#ex.13 - Employees Average Salaries
SELECT e.department_id, 
	   IF(e.department_id = 1, avg(e.salary) + 5000, avg(e.salary)) AS 'avg_salary'
FROM employees AS e
WHERE e.salary > 30000 AND e.manager_id != 42
GROUP BY e.department_id
ORDER BY e.department_id;


#ex.14 - Employees Maximum Salaries
SELECT e.department_id,
	   MAX(e.salary) AS 'max_salary'
FROM employees AS e
GROUP BY e.department_id
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY e.department_id;


#ex.15 - Employees Count Salaries
SELECT COUNT(*) AS ''
FROM employees AS e
WHERE e.manager_id IS NULL;


#ex.16 - 3rd Highest Salary*
SELECT e1.department_id,
       (SELECT DISTINCT e2.salary FROM employees AS e2
		WHERE e1.department_id = e2.department_id
		ORDER BY e2.salary DESC 
        LIMIT 2, 1) AS 'third_highest_salary'
FROM employees AS e1
GROUP BY e1.department_id
HAVING `third_highest_salary` IS NOT NULL
ORDER BY e1.department_id;


#ex.17 - Salary Challenge*


#ex.18 - Departments Total Salaries
SELECT e.department_id,
	   SUM(e.salary) AS 'total_salary'
FROM employees AS e
GROUP BY e.department_id
ORDER BY e.department_id;
