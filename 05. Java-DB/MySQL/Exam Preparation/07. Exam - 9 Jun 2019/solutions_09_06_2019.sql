-- 02 -- Insert
INSERT INTO cards(card_number, card_status, bank_account_id)
SELECT reverse(cl.full_name),
	   'Active',
       cl.id
FROM clients AS cl
WHERE cl.id BETWEEN 191 AND 200;


-- 03 -- Update
UPDATE clients AS c
	JOIN employees_clients AS ec
		ON c.id = ec.employee_id
SET ec.employee_id = (SELECT *
					  FROM (SELECT ec1.employee_id
							FROM employees_clients AS ec1
							GROUP BY ec1.employee_id
							ORDER BY count(ec1.employee_id) asc, ec1.employee_id
							LIMIT 1) AS ec2)
WHERE ec.client_id = ec.employee_id;


-- 04 -- Delete
DELETE e 
FROM employees AS e
	LEFT JOIN employees_clients AS ec
		ON e.id = ec.employee_id
WHERE ec.client_id IS NULL;


-- 05 -- Clients 
SELECT cl.id,
	   cl.full_name
FROM clients AS cl
ORDER BY cl.id ASC;


-- 06 -- Newbies
SELECT e.id,
	   CONCAT(e.first_name, ' ', e.last_name) AS 'full_name',
       CONCAT('$',e.salary) AS 'salary',
       e.started_on
FROM employees AS e
WHERE e.salary >= 100000
	AND e.started_on >= '2018-01-01'
ORDER BY e.salary DESC, e.id;


-- 07 -- Cards against Humanity
SELECT c.id,
	   CONCAT(c.card_number, ' : ', cl.full_name) AS 'card_token'
FROM clients AS cl
	JOIN bank_accounts AS bc
		ON cl.id = bc.client_id
	JOIN cards AS c
		ON bc.id = c.bank_account_id
ORDER BY c.id DESC;


-- 08 -- Top 5 Employees
SELECT CONCAT(e.first_name, ' ', e.last_name) AS 'name',
	   e.started_on,
       COUNT(ec.client_id) AS 'count_of_clients'
FROM employees AS e
	JOIN employees_clients AS ec
		ON e.id = ec.employee_id
GROUP BY e.id
ORDER BY `count_of_clients` DESC, e.id
LIMIT 5;


-- 09 -- Branch cards 
SELECT br.name,
	   COUNT(c.id) AS 'count_of_cards'
FROM branches AS br
	LEFT JOIN employees AS e
		ON br.id = e.branch_id
	LEFT JOIN employees_clients AS ec
		ON e.id = ec.employee_id
	LEFT JOIN clients AS cl
		ON ec.client_id = cl.id
	LEFT JOIN bank_accounts AS bc
		ON cl.id = bc.client_id
	LEFT JOIN cards AS c
		ON bc.id = c.bank_account_id
GROUP BY br.id
ORDER BY `count_of_cards` DESC, br.name;


-- 10 -- Extract card's count
DELIMITER ##

CREATE FUNCTION `udf_client_cards_count`(name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
	SELECT COUNT(c.id)
	FROM clients AS cl
		LEFT JOIN bank_accounts AS bc
			ON cl.id = bc.client_id
		LEFT JOIN cards AS c
			ON bc.id = c.bank_account_id
	WHERE cl.full_name = name
 );
END;
##
DELIMITER ;

SELECT c.full_name, udf_client_cards_count('Baxy David') as `cards` FROM clients c
WHERE c.full_name = 'Baxy David';
-- cards 6


-- 11 -- Client Info
DELIMITER ##

CREATE PROCEDURE `udp_clientinfo` (full_name VARCHAR(50))
BEGIN 
	SELECT cl.full_name,
		   cl.age,
		   bc.account_number,
		   concat('$', bc.balance) AS 'balance'
	FROM clients AS cl
		JOIN bank_accounts AS bc
			ON cl.id = bc.client_id
	WHERE cl.full_name = full_name;
END;
##

DELIMITER ;	

CALL `udp_clientinfo` ('Hunter Wesgate');
-- 'Hunter Wesgate' 33 69666616-8 $803355.32