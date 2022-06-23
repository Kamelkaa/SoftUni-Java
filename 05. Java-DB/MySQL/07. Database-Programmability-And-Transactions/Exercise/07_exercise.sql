#ex.1 - Employees with Salary Above 35000
DELIMITER ##
CREATE PROCEDURE `usp_get_employees_salary_above_35000` ()
BEGIN
	SELECT e.first_name,
		   e.last_name
	FROM employees AS e
	WHERE e.salary > 35000
	ORDER BY e.first_name, 
			 e.last_name, 
			 e.employee_id;
END
## 
DELIMITER ;
 CALL `usp_get_employees_salary_above_35000`;


#ex.2 - Employees with Salary Above Number
DELIMITER ##
CREATE PROCEDURE `usp_get_employees_salary_above` (above_parameter DECIMAL(10, 4))
BEGIN
	SELECT e.first_name,
		   e.last_name
	FROM employees AS e
	WHERE e.salary >= above_parameter
	ORDER BY e.first_name,
			 e.last_name,
			 e.employee_id;
END
##
DELIMITER ;
CALL usp_get_employees_salary_above (450000)

#ex.3 - Town Names Starting With
DELIMITER ##
CREATE PROCEDURE `usp_get_towns_starting_with` (start_name VARCHAR(20))
BEGIN
	SELECT t.name AS 'town_name'
	FROM towns AS t
	WHERE t.name LIKE concat(start_name, '%')
	ORDER BY t.name;
END
##
DELIMITER ;
CALL usp_get_towns_starting_with('b');


#ex.4 - Employees from Town
DELIMITER ##
CREATE PROCEDURE `usp_get_employees_from_town` (town_name VARCHAR(45))
BEGIN
	SELECT e.first_name,
		   e.last_name
	FROM employees AS e
		JOIN addresses AS a
			ON e.address_id = a.address_id
		JOIN towns AS t
			ON a.town_id = t.town_id
	WHERE t.name = town_name
	ORDER BY e.first_name, e.last_name, e.employee_id;
END
##
DELIMITER ;
CALL usp_get_employees_from_town ('Sofia');


#ex.5 - Salary Level Function
DELIMITER ##
CREATE FUNCTION `ufn_get_salary_level` (salary DOUBLE(10, 4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
 DECLARE salary_level VARCHAR(20);
        IF salary < 30000 THEN SET salary_level = 'Low';
        ELSEIF salary <= 50000 THEN SET salary_level = 'Average';
        ELSE SET salary_level = 'High';
        END IF;
    RETURN salary_level;
END
##
DELIMITER ;

SELECT e.salary,
	   ufn_get_salary_level(e.salary)
FROM employees AS e;


#ex.6 - Employees by Salary Level 
DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(salary DOUBLE(10, 4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE salary_level VARCHAR(20);
    IF salary < 30000 THEN SET salary_level = 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level = 'Average';
    ELSE SET salary_level = 'High';
    END IF;
    RETURN salary_level;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level TEXT)
BEGIN
    SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    WHERE ufn_get_salary_level(e.`salary`) = salary_level
    ORDER BY e.`first_name` DESC, e.`last_name` DESC;
END $$
DELIMITER ;
CALL usp_get_employees_by_salary_level('High');


#ex.7 - Define Function 
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS BIT
DETERMINISTIC
RETURN word REGEXP(CONCAT('^[', set_of_letters, ']+$'));

SELECT ufn_is_word_comprised('oistmiahf', 'Sofia') AS `result`;


#ex.8 - Find Full Name
DELIMITER $$

CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
    SELECT CONCAT_WS(' ', a.`first_name`, a.`last_name`) AS `full_name`
    FROM `account_holders` AS a
    ORDER BY `full_name`, a.`id`;
END $$
DELIMITER ;
CALL usp_get_holders_full_name();


#ex.9 -People with Balance Higher Than *
DELIMITER $$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(amount DECIMAL(20, 4))
BEGIN
    SELECT ah.`first_name`, ah.`last_name`
    FROM `account_holders` AS ah
    JOIN `accounts` AS a 
    ON ah.`id` = a.`account_holder_id`
    GROUP BY ah.`id`
    HAVING SUM(a.`balance`) > amount
    ORDER BY ah.`id`;
END $$
DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);


#ex.10 - Future Value Function
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(20, 4), 
yearly_interest_rate DECIMAL(20, 4), 
years INT)
RETURNS DECIMAL(20, 4)
DETERMINISTIC
BEGIN
    DECLARE result DECIMAL(20, 4);
    SET result = sum * POWER(1 + yearly_interest_rate, years);
    RETURN result;
END $$
DELIMITER ;
SELECT UFN_CALCULATE_FUTURE_VALUE(1000, 0.50, 5) AS `output`;


#ex.11 - Calculating Interest 
DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(sum DECIMAL(20, 4), 
yearly_interest_rate DECIMAL(20, 4), 
years INT)
RETURNS DECIMAL(20, 4)
DETERMINISTIC
BEGIN
    DECLARE result DECIMAL(20, 4);
    SET result = sum * POWER(1 + yearly_interest_rate, years);
    RETURN result;
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest DECIMAL(20, 4))
BEGIN
SELECT 
    a.`id`,
    ah.`first_name`,
    ah.`last_name`,
    a.`balance` AS `current_balance`,
    ufn_calculate_future_value(a.`balance`, interest, 5) AS `balance_in_5_years`
FROM
    `account_holders` AS ah
        JOIN
    `accounts` AS a ON ah.`id` = a.`account_holder_id`
WHERE
    a.`id` = account_id;
END $$
DELIMITER ;
CALL usp_calculate_future_value_for_account(1, 0.1);


#ex.12 - Deposit Money 
DELIMITER ##
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19,4))
BEGIN
IF( money_amount > 0 ) THEN
START TRANSACTION;
UPDATE accounts
SET balance = balance + money_amount
WHERE id = account_id;
END IF;
END
##
DELIMITER ;


#ex.13 - 




#ex.14 - 
DELIMITER ##
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19,4))
BEGIN
 
 IF (amount <= 0
 OR
 EXISTS (SELECT id FROM accounts WHERE id = to_account_id) = 0
 OR 
EXISTS (SELECT id FROM accounts WHERE id = from_account_id) =0
OR
from_account_id = to_account_id
OR 
(SELECT balance FROM accounts WHERE id = from_account_id ) - amount < 0)
THEN ROLLBACK;
ELSE
START TRANSACTION;
UPDATE accounts
SET balance = balance - amount
WHERE id = from_account_id;
UPDATE accounts
SET balance = balance + amount
WHERE id = to_account_id;
END IF;
END
##
DELIMITER ;

#ex.15 - Log Accounts Trigger *
CREATE TABLE `logs`(
`log_id` INT PRIMARY KEY AUTO_INCREMENT,
`account_id` INT NOT NULL,
`old_sum` DECIMAL(20, 4),
`new_sum` DECIMAL(20, 4));

DELIMITER $$

CREATE TRIGGER tr_balance_change
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
    IF OLD.balance <> NEW.balance THEN
    INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum`)
    VALUES
    (OLD.id, ROUND(OLD.balance, 4), ROUND(NEW.balance, 4));
    END IF;
END $$
DELIMITER ;


#ex.16 - Emails Trigger*
CREATE TABLE `logs`(
`log_id` INT PRIMARY KEY AUTO_INCREMENT,
`account_id` INT NOT NULL,
`old_sum` DECIMAL(20, 4),
`new_sum` DECIMAL(20, 4));

DELIMITER $$

CREATE TRIGGER tr_balance_change
AFTER UPDATE
ON `accounts`
FOR EACH ROW
BEGIN
    IF OLD.balance <> NEW.balance THEN
    INSERT INTO `logs` (`account_id`, `old_sum`, `new_sum`)
    VALUES
    (OLD.id, ROUND(OLD.balance, 4), ROUND(NEW.balance, 4));
    END IF;
END $$

CREATE TABLE notification_emails(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`recipient` INT NOT NULL,
`subject` VARCHAR(50) NOT NULL,
`body` TEXT NOT NULL);

DELIMITER $$

CREATE TRIGGER tr_notifications_emails
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
    INSERT INTO notification_emails(`recipient`, `subject`, `body`)
    VALUES
    (NEW.account_id,
    CONCAT('Balance change for account: ', NEW.account_id),
    CONCAT('On ', DATE_FORMAT(NOW(), '%b %d %Y at %r'), 
        ' your balance was changed from ', NEW.old_sum, ' to ', NEW.new_sum, '.'));
END $$
DELIMITER ;