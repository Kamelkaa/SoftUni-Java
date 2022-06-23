#Training
CREATE TABLE `categories` (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL
);

CREATE TABLE `products` (
    `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `category_id` INT,
    CONSTRAINT `my_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
);

#Filling the table
INSERT INTO `employees` (`first_name`, `last_name`)
VALUES 
('Test', 'Test'),
('Test1', 'Test1'),
('Test2', 'Test2');

#Changing field
UPDATE `employees` 
SET `first_name` = 'Change NameTest'
WHERE (`id` = 2);

#Delete Row
DELETE FROM `employees` 
WHERE (`id` = 3);

#Delete all the entries in a table
TRUNCATE TABLE `employees`;

#Delete table
DROP TABLE `employees`;

#To drop entire database - DELETE database
DROP DATABASE `gamebar`;

#LAB:
CREATE DATABASE `gamebar`;
USE `gamebar`;

#ex.1 - Create Tables
CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL
);

CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL
);

CREATE TABLE `products` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`category_id` INT NOT NULL
);

#ex.2 - Insert Data in Tables
INSERT INTO `employees` (`first_name`, `last_name`)
VALUES
('Test First', 'Test Last'),
('Test First1', 'Test Last1'),
('Test First2', 'Test Last2');

#ex.3 - Alter Tables
ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(20) NOT NULL;

#ex.4 - Adding Constraints
ALTER TABLE `products`
ADD CONSTRAINT `fk_products_categories`
FOREIGN KEY `products` (`category_id`)
REFERENCES `categories` (`id`); 

#ex.5 - Modifying Columns
ALTER TABLE `employees`
CHANGE COLUMN `middle_name` `middle_name` VARCHAR(100);
