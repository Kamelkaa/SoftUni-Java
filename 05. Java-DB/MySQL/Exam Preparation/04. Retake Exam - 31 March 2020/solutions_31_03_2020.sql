-- 02 -- Insert
INSERT INTO addresses(address, town, country, user_id)
SELECT u.username,
	   u.`password`,
       u.ip,
       u.age
FROM users AS u
WHERE u.gender = 'M'; -- ?


-- 03 -- Update 
SET SQL_SAFE_UPDATES = 0;

UPDATE addresses
SET country = (CASE 
					WHEN country LIKE 'B%' THEN 'Blocked'
                    WHEN country LIKE 'T%' THEN 'Test'
                    WHEN country LIKE 'P%' THEN 'In Progress'
                    ELSE country 
				END);
                
                
-- 04 -- Delete
DELETE FROM addresses
WHERE (id % 3) = 0;


-- 05 -- Users
SELECT u.username,
	   u.gender,
       u.age
FROM users AS u
ORDER BY u.age DESC, u.username ASC;


-- 06 -- Extract 5 most commented photos
SELECT ph.id,
	   ph.date AS 'date_and_time',
       ph.description,
       COUNT(c.photo_id) AS 'commentsCount'
FROM photos AS ph
	JOIN comments AS c
		ON ph.id = c.photo_id
GROUP BY ph.id
ORDER BY `commentsCount` DESC, ph.id
LIMIT 5;


-- 07 -- Lucky Users
SELECT concat(u.id, ' ', u.username) AS 'id_username',
	   u.email
FROM users AS u
	JOIN users_photos AS up
		ON u.id = up.user_id
WHERE up.user_id = up.photo_id
ORDER BY u.id ASC;


-- 08 -- Count likes and comments
SELECT  ph.id,
	    COUNT(DISTINCT l.id) AS 'likes_count',
        COUNT(DISTINCT c.id) AS 'comments_count'
FROM photos AS ph
	LEFT JOIN likes AS l
		ON ph.id = l.photo_id
	LEFT JOIN comments AS c
		ON c.photo_id = ph.id
GROUP BY ph.id
ORDER BY likes_count DESC, comments_count DESC, ph.id;


-- 09 -- The photo on the tenth day of the month
SELECT concat(substring(`description`, 1, 30), '...') AS 'summary',
	   ph.date
FROM photos AS ph
WHERE day(ph.date) = '10'
ORDER BY ph.date DESC;


-- 10 -- Get user’s photos count 
DELIMITER ##

CREATE FUNCTION `udf_users_photos_count`(username VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN (
	SELECT count(up.photo_id)
	FROM users AS u
		JOIN users_photos AS up
			ON u.id = up.user_id
	WHERE u.username = username
);
 
END;
##
DELIMITER ;

SELECT udf_users_photos_count('ssantryd') AS photosCount;
-- 2


-- 11 -- Increase user age
DELIMITER ##

CREATE PROCEDURE `udp_modify_user` (address VARCHAR(30), town VARCHAR(30)) 
BEGIN 
UPDATE users AS u
	JOIN addresses AS a
		ON u.id = a.user_id
SET u.age = u.age + 10
WHERE a.address = address AND a.town = town;

END;
##

DELIMITER ;

SET SQL_SAFE_UPDATES = 0;
CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');

SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';
-- eblagden21	eishak21@skyrock.com	M	91	Associate Professor

