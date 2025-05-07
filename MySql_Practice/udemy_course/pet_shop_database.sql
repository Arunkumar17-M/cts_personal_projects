use pet_shop;

show tables;

show columns from dogs;
-- above and below will give same result desc means describe
desc cats;

drop table cats;

create table cats(
	name varchar(50),
    age int
);

create table dogs(
	name varchar(50),
    breed varchar(50),
    age int
);

create table pastries(
	name varchar(50),
    quantity int
);

desc pastries;

drop table pastries;

insert into cats(name, age)
values ('Blue steele', 5);

insert into cats(name, age)
values ("jenkins", 7);

insert into cats(name, age)
values ("Metaball", 2),
		("Turkey", 15), 
        ("Potato", 3);

select * from cats;

delete from cats
where name = "Blue steele";

create table cats2(
	name varchar(50) not null,
    age int not null
);

insert into cats2(name, age)
values ('Bilibo', 56);

create table cats3(
	name varchar(50) default 'no name provided',
    age int default 99
);

-- in th above i can mannully insert null and example is below
insert into cats3(name, age)
values (null, null);
-- so better to use not null if you the value should not be null

drop table cats3;

create table cats3(
	name varchar(50) not null default 'unname',
    age int not null default 99
);

insert into cats3() values();

select * from cats3;

create table unique_cats(
	cat_id int not null primary key,
    name varchar(100) not null,
    age int not null
);

-- below is another method to put primary key
create table unique_cats(
	cat_id int,
    name varchar(100) not null, 
    age int not null,
    primary key(cat_id)
);

desc unique_cats;

insert into unique_cats(cat_id, name, age)
values (1, 'bingo', 3);

insert into unique_cats(cat_id, name, age)
values (null, 'binigo', 3);

select * from unique_cats;

drop table unique_cats;


create table unique_cats3(
	cat_id int auto_increment,
    name varchar(100) not null,
    age int not null,
    primary key(cat_id)
);

insert into unique_cats3(name, age)
values ('bingo', 5);

select * from unique_cats3;

SELECT cat_id AS id, name FROM cats;

INSERT INTO cats(name, breed, age)
VALUES ('Ringo', 'Tabby', 4),
		('Cindy', 'Maine Coon', 10),
		('Dumbledore', 'Maine Coon', 11),
        ('Egg', 'Persian', 4),
        ('Misty', 'Tabby', 13),
        ('George Michael', 'Ragdoll', 9),
        ('Jackson', 'Sphynx', 7);

UPDATE cats SET breed = 'Shorthair' WHERE breed = 'Tabby';

UPDATE cats SET age = 14 WHERE name = 'Misty';

DELETE FROM cats WHERE name = 'Egg';