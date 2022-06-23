#ex.0 - Create Database
CREATE DATABASE `minions`;
USE `minions`;


#ex.1 - Create Tables
CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20),
`age` INT
);
CREATE TABLE `towns` (
`town_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20)
);


#ex.2 - Alter Minions Table
ALTER TABLE `towns`
CHANGE COLUMN `id` `id` INT AUTO_INCREMENT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT,
ADD CONSTRAINT `fk_minions_towns` FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`);


#ex.3 - Insert Records in Both Tables
INSERT INTO `towns` (`id`,`name`)
VALUES
('1', 'Sofia'),
('2', 'Plovdiv'),
('3', 'Varna');

INSERT INTO `minions` (`id`, `name`, `age`, `town_id`)
VALUES
('1', 'Kevin', '22', '1'),
('2','Bob', '15', '3'),
('3', 'Steward', NULL, '2');


#ex.4 - Truncate Table Minions
TRUNCATE TABLE `minions`;


#ex.5 - Drop All Tables
DROP TABLE `minions`;
DROP TABLE `towns`;


#ex.6 - Create Table People
CREATE TABLE `people`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL,
`picture` BLOB,
`height` DOUBLE(10,2),
`weight` DOUBLE(10,2),
`gender` CHAR(1) NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` (`name`, `gender`, `birthdate`)
VALUES
('Name1', 'M', DATE(NOW())),
('Name2', 'F', DATE(NOW())),
('Name3', 'M', DATE(NOW())),
('Name4', 'F', DATE(NOW())),
('Name5', 'M', DATE(NOW()));


#ex.7 - Create Table Users
CREATE TABLE `users`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (`username`, `password`)
VALUES
('Username1', 'Pass1'),
('Username2', 'Pass2'),
('Username3', 'Pass3'),
('Username4', 'Pass4'),
('Username5', 'Pass5');


#ex.8 - Change Primary Key
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY `users` (`id`, `username`);


#ex.9 - Set Default Value of a Field
ALTER TABLE `users`
CHANGE COLUMN `last_login_time` `last_login_time` DATETIME DEFAULT NOW();


#ex.10 - Set Unique Field
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users`
PRIMARY KEY `users` (`id`),
CHANGE COLUMN `username` `username` VARCHAR(50) UNIQUE; 


#ex.11 - Movies Database
CREATE DATABASE `movies`;
USE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`director_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `directors` (`director_name`, `notes`)
VALUES
('Name1','Notes1'),
('Name2','Notes2'),
('Name3','Notes3'),
('Name4','Notes4'),
('Name5','Notes5');

CREATE TABLE `genres`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `genres` (`genre_name`, `notes`)
VALUES
('Name1','Notes1'),
('Name2','Notes2'),
('Name3','Notes3'),
('Name4','Notes4'),
('Name5','Notes5');

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

INSERT INTO `categories` (`category_name`, `notes`)
VALUES
('Name1','Notes1'),
('Name2','Notes2'),
('Name3','Notes3'),
('Name4','Notes4'),
('Name5','Notes5');

CREATE TABLE `movies`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` INT,
`length` INT,
`genre_id` INT,
`category_id` INT,
`rating` DOUBLE,
`notes` TEXT
);

INSERT INTO `movies` (`title`, `notes`)
VALUES
('Title1','Notes1'),
('Title2','Notes2'),
('Title3','Notes3'),
('Title4','Notes4'),
('Title5','Notes5');


#ex.12 - Car Rental Database
CREATE DATABASE `car_rental`;
USE `car_rental`;

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`category` VARCHAR(30),
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

INSERT INTO `categories` (`category`)
VALUES
('Category1'),
('Category2'),
('Category3');

CREATE TABLE `cars` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`plate_number` VARCHAR(30),
`make` VARCHAR(30),
`model` VARCHAR(30),
`car_year` INT,
`category_id` INT,
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(30),
`available` BOOLEAN
);

INSERT INTO `cars` (`plate_number`)
VALUES
('Plate1'),
('Plate2'),
('Plate3');

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(30),
`last_name` VARCHAR(30),
`title` VARCHAR(30),
`notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 
('TestName1', 'TestName1'),
('TestName2', 'TestName2'),
('TestName3', 'TestName3');

CREATE TABLE `customers`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(30),
`full_name` VARCHAR(30),
`address` VARCHAR(50),
`city` VARCHAR(20),
`zip_code` VARCHAR(10),
`notes` TEXT
);

INSERT INTO `customers` (`driver_licence_number`, `full_name`)
VALUES
('Licence1', 'Name1'),
('Licence2', 'Name2'),
('Licence3', 'Name3');

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(30),
`tank_level` VARCHAR(20),
`kilometrage_start` INT,
`kilometrage_end` INT,
`total_kilometrage` INT,
`start_date` DATE,
`end_date` DATE,
`total_days` INT,
`rate_applied` DOUBLE,
`tax_rate` DOUBLE,
`order_status` VARCHAR(20),
`notes` TEXT
);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`)
VALUES 
(1, 2),
(2, 3),
(3, 1);


#ex.13 - Basic Insert 
CREATE DATABASE `soft_uni`;
USE `soft_uni`;

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `addresses` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(50) NOT NULL,
`town_id` INT
);

CREATE TABLE `departments` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50),
`last_name` VARCHAR(50) NOT NULL,
`job_title` VARCHAR(50),
`department_id` INT NOT NULL,
`hire_date` DATE,
`salary` DECIMAL(19,2),
`address_id` INT,
CONSTRAINT `fk_employees_departments`
FOREIGN KEY `employees` (`department_id`) REFERENCES `departments` (`id`),
CONSTRAINT `fk_employees_addresses`
FOREIGN KEY `employees` (`address_id`) REFERENCES `addresses` (`id`)
);

INSERT INTO `towns` (`name`)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments` (`name`)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO `employees` (`first_name`,`middle_name`, `last_name`, `job_title`, `department_id`, `hire_date`, `salary`)
VALUES
('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);


#ex.14 - Basic Select All Fields
SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;


#ex.15 - Basic Select All Fields and Order Them
SELECT * FROM `towns`
ORDER BY `name`;
SELECT * FROM `departments`
ORDER BY `name`;
SELECT * FROM `employees`
ORDER BY `salary` DESC;


#ex.16 - Basic Select Some Fields
SELECT `name` FROM `towns`;
SELECT `name` FROM `departments`;
SELECT `first_name`, `last_name`, `job_title`, `salary` FROM `employees`;


#ex.17 - Increase Employees Salary
UPDATE `employees`
SET `salary` = `salary` * 1.1;
SELECT `salary` FROM `employees`;


#ex.18 - Delete All Records
DELETE FROM occupancies;