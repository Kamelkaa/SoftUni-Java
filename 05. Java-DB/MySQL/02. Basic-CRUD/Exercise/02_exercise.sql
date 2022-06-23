-- soft_uni --
#ex.1 - Find All Information About Departments
SELECT * FROM `departments`
ORDER BY `department_id`;


#ex.2 - Find all Department Names
SELECT `name` FROM `departments`
ORDER BY `department_id`;


#ex.3 - Find Salary of Each Employee
SELECT `first_name`, `last_name`, `salary` FROM  `employees`
ORDER BY `employee_id`;


#ex.4 - Find Full Name of Each Employee
SELECT `first_name`, `middle_name`, `last_name` FROM  `employees`
ORDER BY `employee_id`;


#ex.5 - Find Email Address of Each Employee
SELECT CONCAT(`first_name`,
            '.',
            `last_name`,
            '@softuni.bg') AS `full_ email_address`
FROM `employees`;


#ex.6 - Find All Different Employee’s Salaries
SELECT DISTINCT `salary` FROM `employees`;


#ex.7 - Find all Information About Employees
SELECT * FROM `employees`
WHERE `job_title` = 'Sales Representative'
ORDER BY `employee_id`;


#ex.8 - Find Names of All Employees by Salary in Range
SELECT `first_name`, `last_name`, `job_title` FROM `employees`
WHERE `salary` BETWEEN 20000 AND 30000;


#ex.9 - Find Names of All Employees
SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`) AS `Full Name`
FROM `employees`
WHERE `salary` IN (25000, 14000, 12500, 23600);


#ex.10 - Find All Employees Without Manager
SELECT `first_name`, `last_name` FROM `employees`
WHERE `manager_id` IS NULL;


#ex.11 - Find All Employees with Salary More Than
SELECT `first_name`, `last_name`, `salary` FROM `employees`
WHERE `salary` > 50000
ORDER BY `salary` DESC;


#ex.12 - Find 5 Best Paid Employees
SELECT `first_name`, `last_name` FROM `employees`
ORDER BY `salary` DESC LIMIT 5;


#ex.13 - Find All Employees Except Marketing
SELECT `first_name`, `last_name` FROM `employees`
WHERE `department_id` != 4;


#ex.14 - Sort Employees Table
SELECT * FROM `employees`
ORDER BY `salary` DESC, `first_name` ASC, `last_name` DESC, `middle_name` ASC;


#ex.15 - Create View Employees with Salaries
CREATE VIEW `v_employees_salaries` AS
SELECT `first_name`, `last_name`, `salary` FROM `employees`;

SELECT * FROM `v_employees_salaries`;


#ex.16 - Create View Employees with Job Titles
CREATE VIEW `v_employees_job_titles` AS
SELECT concat_ws(' ', `first_name`, `middle_name`, `last_name`) AS `full_name`, `job_title`
FROM `employees`;

SELECT * FROM `v_employees_job_titles`;


#ex.17 - Distinct Job Titles
SELECT DISTINCT `job_title` FROM `employees`
ORDER BY `job_title`;


#ex.18 - Find First 10 Started Projects
SELECT * FROM `projects`
ORDER BY `start_date` ASC, `name` ASC, `project_id` ASC LIMIT 10; 


#ex.19 - Last 7 Hired Employees
SELECT `first_name`, `last_name`, `hire_date` FROM `employees`
ORDER BY `hire_date` DESC LIMIT 7;


#ex.20 - Increase Salaries
UPDATE `employees`
SET `salary` = `salary` * 1.12
WHERE `department_id` IN (1, 2, 4, 11);

SELECT `salary` FROM `employees`;


-- geographyi --
#ex.21 - All Mountain Peaks
SELECT `peak_name` FROM `peaks`
ORDER BY `peak_name`;


#ex.22 - Biggest Countries by Population
SELECT `country_name`, `population` FROM `countries`
WHERE `continent_code` = 'EU'
ORDER BY `population` DESC, `country_name` ASC LIMIT 30;


#ex.23 - Countries and Currency (Euro / Not Euro)
SELECT `country_name`, `country_code`, IF(`currency_code` = 'EUR', 'Euro','Not Euro') AS `currency`
FROM `countries`
ORDER BY `country_name`;


-- diablo --
#ex.24 - All Diablo Characters
SELECT `name` FROM `characters`
ORDER BY `name` ASC;