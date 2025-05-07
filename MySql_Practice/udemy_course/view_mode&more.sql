SELECT title, released_year, genre, rating, first_name, last_name
FROM reviews
JOIN series ON series.id = reviews.series_id
JOIN reviewers ON reviewers.id = reviews.reviewer_id;

-- view is used to make table like that from the above query and
-- used that table as many queries as useful

CREATE VIEW full_reviews AS
-- above only one line is syntax use and below is above query
SELECT title, released_year, genre, rating, first_name, last_name
FROM reviews
JOIN series ON series.id = reviews.series_id
JOIN reviewers ON reviewers.id = reviews.reviewer_id;

SELECT * FROM full_reviews;

SELECT * FROM full_reviews
WHERE genre = 'Animation';

CREATE VIEW ordered_series AS
SELECT * FROM series ORDER BY released_year;

CREATE OR REPLACE VIEW ordered_series AS
SELECT * FROM series ORDER BY released_year DESC;

ALTER VIEW ordered_series AS
SELECT * FROM series ORDER BY released_year;

DROP VIEW ordered_series;

SELECT title, 
	AVG(rating),
	COUNT(rating) AS review_count
FROM full_reviews
GROUP BY title
HAVING COUNT(rating) > 1;

SELECT title, AVG(rating) FROM full_reviews
GROUP BY title WITH ROLLUP;

SELECT title, COUNT(rating) FROM full_reviews
GROUP BY title WITH ROLLUP;

SELECT first_name, released_year, genre, AVG(rating) FROM full_reviews
GROUP BY released_year, genre, first_name WITH ROLLUP;

-- To View Modes:
SELECT @@GLOBAL.sql_mode;
SELECT @@SESSION.sql_mode;

-- To Set them
SET GLOBAL sql_mode = 'choose mode from above and use here';
SET SESSION sql_mode = 'choose mode from above and use here';