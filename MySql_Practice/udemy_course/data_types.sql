CREATE TABLE people(
	name VARCHAR(100),
    birthdate DATE,
    birthtime TIME,
    birthdt DATETIME
);

INSERT INTO people(name, birthdate, birthtime, birthdt)
VALUES ('Elton', '2000-12-25', '11:00:00', '2000-12-25 11:00:00');

INSERT INTO people (name, birthdate, birthtime, birthdt)
VALUES ('Lulu', '1985-04-11', '9:45:10', '1985-04-11 9:45:10');
 
INSERT INTO people (name, birthdate, birthtime, birthdt)
VALUES ('Juan', '2020-08-15', '23:59:00', '2020-08-15 23:59:00');

DESC people;

SELECT * FROM people;

SELECT CURDATE();

SELECT CURTIME();

SELECT NOW();

INSERT INTO people(name, birthdate, birthtime, birthdt)
VALUES ('Hazel', CURDATE(), CURTIME(), NOW());

SELECT birthdate, DAY(birthdate), DAYOFWEEK(birthdate), DAYOFYEAR(birthdate) FROM people;
-- 1-sunday, 2-monday and so on.

SELECT birthdate, MONTHNAME(birthdate), YEAR(birthdate) FROM people;

SELECT birthtime, HOUR(birthtime), MINUTE(birthtime), SECOND(birthtime) FROM people;

SELECT
	birthdt,
    YEAR(birthdt),
    DAY(birthdt),
    HOUR(birthdt),
    MINUTE(birthdt)
FROM people;

SELECT birthdt, DATE_FORMAT(birthdt, '%D %b %Y') FROM people;

SELECT birthdt, DATE_FORMAT(birthdt, '%a %b %D') FROM people;

SELECT birthdt, DATE_FORMAT(birthdt, '%H %i') FROM people;

SELECT birthdt, DATE_FORMAT(birthdt, 'BORN ON: %r') FROM people;

CREATE TABLE captions(
	text VARCHAR(100),
    created_at TIMESTAMP default CURRENT_TIMESTAMP
);

CREATE TABLE captions2(
	text VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- -----------------------------------------------
-- --------------HERE AFTER PRACTICE--------------

-- What's a good use case for CHAR?
 
-- Used for text that we know has a fixed length, e.g., State abbreviations, 
-- abbreviated company names, etc.

CREATE TABLE inventory(
	item_name VARCHAR(100),
    price DOUBLE,
    quantity INT
);

-- What's the difference between DATETIME and TIMESTAMP?
 
-- They both store datetime information, but there's a difference in the range, 
-- TIMESTAMP has a smaller range. TIMESTAMP also takes up less space. 
-- TIMESTAMP is used for things like meta-data about when something is created
-- or updated.

SELECT CURTIME();

SELECT CURDATE();

SELECT DAYOFWEEK(CURDATE());

SELECT DATE_FORMAT(CURDATE(), '%W');-- this is ok but not fully correct check below statement
SELECT DAYNAME(CURTIME());

SELECT DATE_FORMAT(NOW(), '%m/%d/%Y');

SELECT DATE_FORMAT(NOW(), '%M %D at %H:%i');

CREATE TABLE tweets(
	content VARCHAR(180),
    username VARCHAR(50),
    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tweets (content, username) VALUES('this is my first tweet', 'coltscat');
SELECT * FROM tweets;

INSERT INTO tweets (content, username) VALUES('this is my second tweet', 'coltscat');

DESC tweets;

