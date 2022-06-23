-- soft_uni --
#ex.1 - Find Names of All Employees by First Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;


#ex.2 - Find Names of All Employees by Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;


#ex.3 - Find First Names of All Employess
SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10)
AND extract(year FROM `hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;


#ex.4 - Find All Employees Except Engineers
SELECT `first_name`, `last_name` FROM `employees`
WHERE NOT lower(`job_title`) LIKE '%engineer%'
ORDER BY `employee_id`;


#ex.5 - Find Towns with Name Length
SELECT `name` FROM `towns`
WHERE char_length(`name`) IN (5, 6)
ORDER BY `name` ASC;


#ex.6 - Find Towns Starting With
SELECT `town_id`, `name` FROM `towns`
WHERE SUBSTRING(`name`, 1, 1) IN ('M', 'B', 'K', 'E')
ORDER BY `name` ASC;

SELECT `town_id`, `name` FROM `towns`    -- with Regex
WHERE `name` REGEXP '^[MmBbKkEe]'
ORDER BY `name` ASC;             


#ex.7 - Find Towns Not Starting With
SELECT `town_id`, `name` FROM `towns`
WHERE NOT SUBSTRING(`name`, 1, 1) IN ('R', 'B', 'D')
ORDER BY `name` ASC;


#ex.8 - Create View Employees Hired After
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE extract(year FROM `hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;


#ex.9 - Length of Last Name
SELECT `first_name`, `last_name` FROM `employees`
WHERE char_length(`last_name`) = 5;


-- geography --
#ex.10 - Countries Holding 'A'
SELECT `country_name`, `iso_code` FROM `countries`
WHERE LOWER(`country_name`) LIKE '%a%a%a%'
ORDER BY `iso_code`;

SELECT `country_name`, `iso_code` FROM `countries`  -- 2 --
WHERE char_length(`country_name`) - char_length(replace(lower(`country_name`), 'a', '')) >= 3
ORDER BY `iso_code`;


#ex.11 - Mix of Peak and River Names
SELECT `peaks`.`peak_name`, `rivers`.`river_name`,
lower(concat(`peaks`.`peak_name`,substring(`rivers`.`river_name`, 2))) AS `mix`
FROM `peaks`, `rivers`
WHERE substring(lower(`peaks`.`peak_name`), -1, 1) = substring(lower(`rivers`.`river_name`), 1, 1)
ORDER BY `mix`;

SELECT `peaks`.`peak_name`, `rivers`.`river_name`,  -- 2 --
lower(concat(`peaks`.`peak_name`, RIGHT(`rivers`.`river_name`, char_length(`rivers`.`river_name`) - 1))) AS `mix`
FROM `peaks`, `rivers`
WHERE lower(RIGHT(`peaks`.`peak_name`, 1)) = lower(LEFT(`rivers`.`river_name`, 1))
ORDER BY `mix`;


-- diablo --games
#ex.12 - Games From 2011 and 2012 Year
SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS `start`
FROM `games`
WHERE EXTRACT(YEAR FROM `start`) BETWEEN 2011 AND 2012
ORDER BY `start` , `name` LIMIT 50;


#ex.13 - User Email Providers
SELECT 
    `user_name`,
    SUBSTRING(`email`, LOCATE('@', `email`) + 1) AS `email provider`
FROM `users`
ORDER BY `email provider` , `user_name`;


#ex.14 -  Get Users with IP Address Like Pattern
SELECT `user_name`, `ip_address` FROM `users`
WHERE `ip_address` LIKE '___.1%.%.___'
ORDER BY `user_name`;


#ex.15 - Show All Games with Duration
SELECT 
    `name` AS `game`,
    CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END AS `Part of the Day`,
    CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS `Duration`
FROM `games`;
 
 
 #ex.16 - Orders Table
 SELECT 
    `product_name`,
    `order_date`,
    ADDDATE(`order_date`, INTERVAL 3 DAY) AS `pay_due`,
    ADDDATE(`order_date`, INTERVAL 1 MONTH) AS `deliver_due`
FROM
    `orders`;
 

