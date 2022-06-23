-- 02 -- Insert
INSERT INTO games(name, rating, budget, team_id)
SELECT lower(reverse(substring(t.name, 2))),
	   t.id,
       t.leader_id * 1000,
       t.id
FROM teams AS t
WHERE t.id BETWEEN 1 AND 9;


-- 03 -- Update
UPDATE employees
SET salary = salary + 1000
WHERE age < 40
	AND slary < 5000;
    

-- 04 -- Delete 
SET SQL_SAFE_UPDATES = 0;

DELETE g 
FROM games AS g
	LEFT JOIN games_categories AS gc
		ON g.id = gc.game_id
WHERE gc.category_id IS NULL
	AND g.release_date IS NULL;
    

-- 05 -- Employees
SELECT e.first_name,
	   e.last_name,
       e.age,
       e.salary,
       e.happiness_level
FROM employees AS e
ORDER BY e.salary, e.id;


-- 06 -- Addresses of the teams
SELECT t.name AS 'team_name',
	   a.name AS 'address_name',
       char_length(a.name) AS 'count_of_characters'
FROM teams AS t
	LEFT JOIN offices AS o
		ON t.office_id = o.id
	LEFT JOIN addresses as a
		ON o.address_id = a.id
WHERE o.website IS NOT NULL
ORDER BY t.name, a.name;


-- 07 -- Categories Info
SELECT c.name,
	   count(g.id) AS 'games_count',
       round(AVG(g.budget), 2) AS 'avg_budget',
       MAX(g.rating) AS 'max_rating'
FROM categories AS c
	JOIN games_categories AS gc
		ON c.id = gc.category_id
	JOIN games AS g
		ON gc.game_id = g.id
GROUP BY c.name
HAVING `max_rating` >= 9.5
ORDER BY `games_count` DESC, c.name;


-- 08 -- Games of 2022
SELECT g.name,
	   g.release_date,
       concat(substring(g.description, 1, 10), '...') AS 'summary',
       CASE 
			WHEN month(g.release_date) IN (01, 02, 03) THEN 'Q1'
            WHEN month(g.release_date) IN (04, 05, 06) THEN 'Q2' 
            WHEN month(g.release_date) IN (07, 08, 09) THEN 'Q3'
            ELSE 'Q4'
	   END AS 'quarter',
       t.name AS 'team_name'
FROM games AS g
	JOIN teams AS t
		ON g.team_id = t.id
WHERE year(g.release_date) = '2022'
	AND month(g.release_date) % 2 = 0
    AND g.name LIKE '%2'
ORDER BY `quarter`;


-- 09 -- Full info for games
SELECT g.name,
	   IF(g.budget < 50000, 'Normal budget', 'Insufficient budget') AS 'budget_level',
       t.name AS 'team_name',
       a.name AS 'address_name'
FROM games AS g
	JOIN teams AS t
		ON g.team_id = t.id
	JOIN offices AS o
		ON o.id = t.office_id
	JOIN addresses AS a
		ON o.address_id = a.id
	LEFT JOIN games_categories AS gc
		ON g.id = gc.game_id
WHERE gc.game_id IS NULL 
	AND g.release_date IS NULL
ORDER BY g.name;


-- 10 -- Find all basic information for a game
DELIMITER ##

CREATE FUNCTION  `udf_game_info_by_name` (game_name VARCHAR (20)) 
RETURNS TEXT
DETERMINISTIC
BEGIN
RETURN (
	SELECT concat('The ', g.name , ' is developed by a ', t.name, ' in an office with an address ', a.name)
    FROM games AS g
		JOIN teams AS t
			ON g.team_id = t.id
		JOIN offices AS o
			ON t.office_id = o.id
		JOIN addresses AS a
			ON o.address_id = a.id
	WHERE g.name = game_name
 );
END;
##
DELIMITER ;

SELECT udf_game_info_by_name('Bitwolf') AS info;
-- The Bitwolf is developed by a Rempel-O'Kon in an office with an address 92 Memorial Park
SELECT udf_game_info_by_name('Fix San') AS info;
-- The Fix San is developed by a Schulist in an office with an address 75 Harper Way


-- 11 -- Update Budget of the Games
DELIMITER ##

CREATE PROCEDURE `udp_update_budget` (min_game_rating FLOAT)
BEGIN 
	UPDATE games AS g
		LEFT JOIN games_categories AS cg
			ON g.id = cg.game_id
	SET g.budget = g.budget + 100000,
	 g.release_date = g.release_date + INTERVAL 1 YEAR -- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	WHERE cg.game_id IS NULL
		AND g.rating > min_game_rating
        AND g.release_date IS NOT NULL;

END;
##

DELIMITER ;	 

SET SQL_SAFE_UPDATES = 0;
CALL udp_update_budget (8);
SELECT SUM(`budget`) FROM  `games`;

-- 
