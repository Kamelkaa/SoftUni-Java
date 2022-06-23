-- soft_uni --
#ex.1 -  Count Employees by Town
DELIMITER ##
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(45))
RETURNS INT
DETERMINISTIC
BEGIN 
RETURN (SELECT count(*) AS 'count'
FROM employees AS e
	JOIN addresses AS a
		ON e.address_id = a.address_id
	JOIN towns AS t
		ON a.town_id = t.town_id
WHERE t.name = town_name);
END;
##
DELIMITER ;
SELECT ufn_count_employees_by_town('Sofia') AS 'count';


#ex.2 - Employees Promotion
DELIMITER ##
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(45)) 
BEGIN
	UPDATE `employees` AS e
		JOIN `departments` AS d
			USING (`department_id`)
	SET `salary` = `salary` * 1.05
	WHERE d.`name` = department_name;
END
## 
DELIMITER ;
CALL usp_raise_salaries('Sales');

SELECT `employee_id`, `salary`
FROM `employees`;


#ex.3 - Employees Promotion By ID
DELIMITER ##

CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
    IF((SELECT COUNT(*) FROM `employees` WHERE `employee_id` = id) > 0)
    THEN
        UPDATE `employees` 
        SET `salary` = `salary` * 1.05
        WHERE `employee_id` = id;
    END IF;
END ##

DELIMITER ;
CALL usp_raise_salary_by_id(17);


#ex.4 - Triggered
CREATE TABLE `deleted_employees` (
    `employee_id` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `middle_name` VARCHAR(50) DEFAULT NULL,
    `job_title` VARCHAR(50) NOT NULL,
    `department_id` INT(10) NOT NULL,
    `salary` DECIMAL(19 , 4 ) NOT NULL
);

CREATE 
    TRIGGER `trigger_employee`
 BEFORE DELETE ON `employees` FOR EACH ROW 
    INSERT INTO `deleted_employees`(
    `first_name`, 
    `last_name`, 
    `middle_name`, 
    `job_title`, 
    `department_id`, 
    `salary`) 
    VALUES (
    OLD.`first_name`, 
    OLD.`last_name`, 
    OLD.`middle_name`, 
    OLD.`job_title`, 
    OLD.`department_id`, 
    OLD.`salary`);