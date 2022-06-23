#ex.1 - Find Book Titles
SELECT `title` FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;


#ex.2 - Replace Titles
SELECT replace(`title`, 'The', '***') FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;


#ex.3 - Sum Cost of All Books
SELECT round(SUM(cost), 2) FROM `books`;


#ex.4 - Days Lived
SELECT concat(`first_name`, ' ', `last_name`) AS 'Full Name', 
timestampdiff(day, `born`, `died`) AS 'Days Lived'
FROM `authors`;


#ex.5 - Harry Potter Books
SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%'
ORDER BY `id`;