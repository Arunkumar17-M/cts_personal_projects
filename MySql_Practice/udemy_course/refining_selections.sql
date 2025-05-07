INSERT INTO books
    (title, author_fname, author_lname, released_year, stock_quantity, pages)
    VALUES ('10% Happier', 'Dan', 'Harris', 2014, 29, 256), 
           ('fake_book', 'Freida', 'Harris', 2001, 287, 428),
           ('Lincoln In The Bardo', 'George', 'Saunders', 2017, 1000, 367);

SELECT DISTINCT author_lname FROM books;

SELECT DISTINCT author_fname, author_lname FROM books;

SELECT DISTINCT CONCAT(author_fname, ' ', author_lname) FROM books;

SELECT * FROM books ORDER BY author_lname;

SELECT * FROM books ORDER BY author_lname DESC;

SELECT * FROM books ORDER BY released_year;

SELECT book_id, author_fname, author_lname, pages FROM books
ORDER BY 2 DESC; -- 2 means in the above author_fname query is given that will be sorted

SELECT book_id, author_fname, author_lname, pages FROM books
ORDER BY 4;

SELECT book_id, author_fname, author_lname, pages FROM books
ORDER BY author_fname, author_lname;

SELECT book_id, author_fname, author_lname, pages FROM books
ORDER BY author_fname, pages DESC; -- only pages will be sorted in descending order

SELECT CONCAT(author_fname, ' ', author_lname) AS author FROM books
ORDER BY author;

SELECT * FROM books LIMIT 5;

SELECT title, released_year FROM books
ORDER BY title LIMIT 5;

SELECT title, released_year FROM books
ORDER BY title LIMIT 0, 5;


SELECT title, released_year FROM books
ORDER BY released_year LIMIT 5, 2; -- first parameter is starting index(index start from 0) and second is number of values;

SELECT * FROM books LIMIT 95,18446744073709551615;

SELECT * FROM books LIMIT 15,1844674407370;

SELECT title, author_fname, author_lname, pages FROM books
WHERE author_fname LIKE '%da%';

SELECT title, author_fname, author_lname, pages FROM books
WHERE title LIKE '%:%';

SELECT * FROM books
WHERE author_fname LIKE '____';

SELECT * FROM books
WHERE author_fname LIKE '_a_';

-- To select books with '%' in their title:
SELECT * FROM books
WHERE title LIKE '%\%%';

-- To select books with an underscore '_' in title:
SELECT * FROM books
WHERE title LIKE '%\_%';

-- -----------------------------------------------
-- --------------HERE AFTER PRACTICE--------------

SELECT title FROM books
WHERE title LIKE '%stories%';

SELECT title, pages FROM books
ORDER BY pages DESC LIMIT 1;

SELECT CONCAT(title, ' - ', released_year) as 'summary' FROM books
ORDER BY released_year DESC LIMIT 3;

SELECT title, author_lname FROM books
WHERE author_lname LIKE '% %';

SELECT title, released_year, stock_quantity FROM books
ORDER BY stock_quantity, title LIMIT 3;

SELECT title, author_lname FROM books
ORDER BY author_lname, title;

SELECT title, author_lname 
FROM books ORDER BY 2,1;

SELECT UPPER(CONCAT('My favorite author is ', author_fname, ' ', author_lname)) AS 'yell'
FROM books
ORDER BY author_lname;

