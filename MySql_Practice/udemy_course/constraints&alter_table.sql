CREATE TABLE contacts(
	name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE
);

INSERT INTO contacts(name, phone)
VALUES ('billybob', '8781213455');

-- This insert would result in an error:
INSERT INTO contacts(name, phone)
VALUES ('billybob', '8781213455');

CREATE TABLE users(
	username VARCHAR(100) NOT NULL,
    age INT CHECK(age > 0)
);

INSERT INTO users(username, age)
VALUES ('catserso', 45);

-- This insert would result in an error:
INSERT INTO users(username, age)
VALUES ('bibino', -3);

CREATE TABLE palindromes(
	word VARCHAR(100) CHECK(REVERSE(word) = word)
);

INSERT INTO palindromes(word)
VALUES ('racecar');

-- This insert would result in an error:
INSERT INTO palindromes(word)
VALUES ('mommy');

CREATE TABLE user2(
	username VARCHAR(100) NOT NULL,
    age INT,
    CONSTRAINT age_not_negative CHECK(age >= 0)
);

INSERT INTO user2(username, age)
VALUES ('catserso', 45);

-- This insert would result in an error:
INSERT INTO user2(username, age)
VALUES ('bibino', -3);

CREATE TABLE palindromes2(
	word VARCHAR(100),
    CONSTRAINT word_is_palindrome CHECK(REVERSE(word) = word)
);

INSERT INTO palindromes2(word)
VALUES ('racecar');

-- This insert would result in an error:
INSERT INTO palindromes2(word)
VALUES ('mommy');

CREATE TABLE companies(
	name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    CONSTRAINT name_address UNIQUE(name, address)
);

INSERT INTO companies(name, address)
VALUES ('blackbird auto', '123 spurce'),
		('luigis pies', '123 spurce');

CREATE TABLE houses(
	purchase_price INT NOT NULL,
    sale_price INT NOT NULL,
    CONSTRAINT sprice_gt_pprice CHECK(sale_price >= purchase_price)
);

INSERT INTO houses(sale_price, purchase_price)
VALUES (200, 100);

INSERT INTO houses(sale_price, purchase_price)
VALUES (300, 400);

ALTER TABLE companies
ADD COLUMN phone VARCHAR(15);

ALTER TABLE companies
ADD COLUMN employee_count INT NOT NULL DEFAULT 1;

ALTER TABLE companies
DROP COLUMN phone;

ALTER TABLE companies
DROP COLUMN employee_count;

RENAME TABLE companies TO suppliers;

ALTER TABLE suppliers
RENAME TO companies;

ALTER TABLE companies
RENAME COLUMN name TO company_name;

-- This will change the column data type and others.
ALTER TABLE companies
MODIFY company_name VARCHAR(100) NOT NULL DEFAULT 'unknown';

ALTER TABLE companies
CHANGE company_name name VARCHAR(255);

ALTER TABLE houses
ADD CONSTRAINT positive_price CHECK(purchase_price >= 0);

INSERT INTO houses(purchase_price, sale_price)
VALUES (-1, 4);

ALTER TABLE houses
DROP CONSTRAINT positive_price;

DESC houses;

