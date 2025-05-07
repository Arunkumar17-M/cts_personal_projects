CREATE DATABASE book_shop;

USE book_shop;

CREATE TABLE books 
	(
		book_id INT AUTO_INCREMENT,
		title VARCHAR(100),
		author_fname VARCHAR(100),
		author_lname VARCHAR(100),
		released_year INT,
		stock_quantity INT,
		pages INT,
		PRIMARY KEY(book_id)
	);
 
INSERT INTO books (title, author_fname, author_lname, released_year, stock_quantity, pages)
VALUES
('The Namesake', 'Jhumpa', 'Lahiri', 2003, 32, 291),
('Norse Mythology', 'Neil', 'Gaiman',2016, 43, 304),
('American Gods', 'Neil', 'Gaiman', 2001, 12, 465),
('Interpreter of Maladies', 'Jhumpa', 'Lahiri', 1996, 97, 198),
('A Hologram for the King: A Novel', 'Dave', 'Eggers', 2012, 154, 352),
('The Circle', 'Dave', 'Eggers', 2013, 26, 504),
('The Amazing Adventures of Kavalier & Clay', 'Michael', 'Chabon', 2000, 68, 634),
('Just Kids', 'Patti', 'Smith', 2010, 55, 304),
('A Heartbreaking Work of Staggering Genius', 'Dave', 'Eggers', 2001, 104, 437),
('Coraline', 'Neil', 'Gaiman', 2003, 100, 208),
('What We Talk About When We Talk About Love: Stories', 'Raymond', 'Carver', 1981, 23, 176),
("Where I'm Calling From: Selected Stories", 'Raymond', 'Carver', 1989, 12, 526),
('White Noise', 'Don', 'DeLillo', 1985, 49, 320),
('Cannery Row', 'John', 'Steinbeck', 1945, 95, 181),
('Oblivion: Stories', 'David', 'Foster Wallace', 2004, 172, 329),
('Consider the Lobster', 'David', 'Foster Wallace', 2005, 92, 343);

select * from books;

SELECT CONCAT('pi', 'ckle');

SELECT CONCAT(author_fname, ' ', author_lname) as author_name from books;

-- below statement will fill the delimiter inbetween column, you can provide delimiter at the start.
SELECT CONCAT_WS(' - ',title, author_fname, author_lname) as author_name from books;

SELECT SUBSTR('Hello World', 1, 5); -- index start from 1

-- below statement will return start from 7 index and next is number of character needs to return
SELECT SUBSTR('Hello World', 7, 3);

-- below statement will return from last, if we give negative number.
SELECT SUBSTR('Hello World', -4);

-- above and below statement are same but name only differ, SUBSTR/SUBSTRING
SELECT SUBSTRING(title, 1, 10) as 'short title' from books;

SELECT CONCAT(SUBSTR(title, 1, 10), '...') as short_title from books;

SELECT CONCAT(SUBSTR(author_fname, 1,1), '.', SUBSTR(author_lname, 1, 1), '.' ) as initial from books;

SELECT REPLACE('Hello World', 'Hell', '%$#@');

SELECT REPLACE('Hello World', 'l', '7');

SELECT REPLACE('Hello Wolrd', 'o', '0');

SELECT REPLACE('Hello Wolrd', 'o', '*');

SELECT REPLACE('cheese bread coffe milk', ' ', ' and ');

SELECT REPLACE(title, 'e', '3') from books;

SELECT REPLACE(title, ' ', '-') from books;

SELECT REVERSE('HelloWorld');

SELECT REVERSE ( 'meow meow');

SELECT REVERSE(author_fname) from books;

SELECT CONCAT(author_fname, REVERSE(author_fname)) from books;

SELECT CHAR_LENGTH('Hello World');
-- LENGTH function also will result the same but it will count the byte,
--  if japanese word is given the result may differ

SELECT CHAR_LENGTH(title) as length from books;

SELECT author_lname, CHAR_LENGTH(author_lname) as 'length' from books;

SELECT CONCAT(author_lname, ' is ', CHAR_LENGTH(author_lname), ' characters long') as 'find length of last name' 
from books;

SELECT lOWER('Hello World');

SELECT UPPER('Hello World');

SELECT UPPER(title) FROM books;

SELECT CONCAT('I Favorite Book is ', UPPER(title)) FROM books;

SELECT CONCAT('I Favorite Book is ', LOWER(title)) FROM books;

SELECT INSERT('Hello Bobby', 6, 0, ' There');

SELECT INSERT('Hello Bobby', 6, 4, ' There');

SELECT LEFT('omghahalol!', 3);

SELECT RIGHT('omghahalol!', 4);

-- SELECT REPEAT('ha', 3) FROM books;

SELECT TRIM('   X    ');

SELECT TRIM(LEADING '.' FROM '.....omghahlol!.....');

SELECT TRIM(TRAILING '.' FROM '.....omghahlol!.....');

SELECT TRIM(BOTH '.' FROM '.....omghahlol!.....');

-- -----------------------------------------------
-- --------------HERE AFTER PRACTICE--------------

SELECT UPPER(REVERSE('Why does my cat look at me with such hatred?'));

SELECT REPLACE(CONCAT('I', ' ', 'Like', ' ', 'Cats'), ' ', '-');
 
 SELECT REPLACE(title, ' ', '->') AS 'title' FROM books;
 
 SELECT author_lname AS 'forwards', REVERSE(author_lname) AS 'backwards' FROM books;
 
 SELECT UPPER(CONCAT(author_fname, ' ', author_lname)) AS 'full name in caps'
 FROM books;
 
 SELECT CONCAT(title, ' was released in ', released_year) AS 'blurb'
 FROM books;
 
 SELECT title, CHAR_LENGTH(title) AS 'character count' FROM books;
 
 SELECT CONCAT(
	SUBSTR(title, 1, 10),  -- we can use LEFT(title, 10) also
    '...'
	) AS 'short title',
    
	CONCAT(author_lname,
    ',',
    author_fname
    ) AS 'author',
    
    CONCAT(stock_quantity,
    ' in stock'
    ) AS 'quantity'
FROM books;
 
 