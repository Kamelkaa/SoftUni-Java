-- 02 -- Insert 
INSERT INTO coaches(first_name, last_name, salary, coach_level)
SELECT p.first_name,
	   p.last_name,
       p.salary * 2,
       char_length(p.first_name)
FROM players AS p
WHERE p.age >= 45;


-- 03 -- Update
SET SQL_SAFE_UPDATES = 0;

UPDATE coaches AS c
	LEFT JOIN players_coaches AS pc
		ON c.id = pc.coach_id
SET c.coach_level = c.coach_level + 1
WHERE pc.coach_id IS NOT NULL
AND c.first_name LIKE 'A%';


-- 04 --  Delete
SET SQL_SAFE_UPDATES = 0;

DELETE p 
FROM players AS p
WHERE p.age >= 45;


-- 05 -- Players
SELECT p.first_name,
	   p.age,
       p.salary
FROM players AS p
ORDER BY p.salary DESC;


-- 06 -- Young offense players without contract
SELECT p.id,
	   CONCAT(p.first_name, ' ', p.last_name) AS 'full_name',
       p.age,
       p.position,
       p.hire_date
FROM players AS p
	JOIN skills_data AS sd
		ON p.skills_data_id = sd.id
WHERE p.age < 23 
	AND p.position LIKE 'A'
    AND p.hire_date IS NULL
    AND sd.strength > 50
ORDER BY p.salary, p.age;


-- 07 -- Detail info for all teams
SELECT t.name,
	   t.established,
       t.fan_base,
       COUNT(p.id) AS 'players_count'
FROM teams AS t
	LEFT JOIN players AS p
		ON t.id = p.team_id
GROUP BY t.id
ORDER BY `players_count` DESC, t.fan_base DESC;


-- 08 -- he fastest player by towns
SELECT MAX(sd.speed) AS 'max_speed',
	   twn.name AS 'town_name'
FROM towns AS twn
	LEFT JOIN stadiums AS s
		ON twn.id = s.town_id
	LEFT JOIN teams AS t
		ON s.id = t.stadium_id
	LEFT JOIN players AS p
		ON t.id = p.team_id
	LEFT JOIN skills_data AS sd
		ON p.skills_data_id = sd.id
WHERE t.name != 'Devify'
GROUP BY twn.id
ORDER BY `max_speed` DESC, twn.name;


-- 09 -- Total salaries and players by country
SELECT c.name,
	   COUNT(p.id) AS 'total_count_of_players',
       SUM(p.salary) AS 'total_sum_of_salaries'
FROM countries AS c
	LEFT JOIN towns AS twn
		ON c.id = twn.country_id
	LEFT JOIN stadiums AS s
		ON s.town_id = twn.id
	LEFT JOIN teams AS t
		ON s.id = t.stadium_id
	LEFT JOIN players AS p
		ON t.id = p.team_id
GROUP BY c.id
ORDER BY `total_count_of_players` DESC, c.name;


-- 10 -- Find all players that play on stadium
DELIMITER ##

CREATE FUNCTION `udf_stadium_players_count` (stadium_name VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
	SELECT COUNT(p.id)
	FROM stadiums AS s
		JOIN teams  AS t
			ON s.id = t.stadium_id
		JOIN players AS p
			ON p.team_id = t.id	
	WHERE s.name = stadium_name
 );
END;
##
DELIMITER ;

SELECT udf_stadium_players_count ('Jaxworks') as `count`; 
-- 14
SELECT udf_stadium_players_count ('Linklinks') as `count`; 
-- 0


-- 11 -- Find good playmaker by teams
DELIMITER ##

CREATE PROCEDURE `udp_find_playmaker` (min_dribble_points INT, team_name VARCHAR(45))
BEGIN 
	SELECT CONCAT(p.first_name, ' ', p.last_name) AS 'full_name',
		   p.age,
		   p.salary,
		   sd.dribbling,
		   sd.speed,
		   t.name AS 'team_name'
	FROM teams AS t 
		JOIN players AS p 
			ON p.team_id = t.id  
		JOIN skills_data AS sd
			ON sd.id = p.skills_data_id
	WHERE t.name = team_name
		AND sd.dribbling > min_dribble_points
		AND sd.speed > (SELECT AVG(sd1.speed) FROM skills_data AS sd1)
	ORDER BY sd.speed DESC
	LIMIT 1;
END;
##

DELIMITER ;	 

CALL udp_find_playmaker (20, 'Skyble');