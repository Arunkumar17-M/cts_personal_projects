create table people(
	first_name varchar(20),
    last_name varchar(20),
    age int
);

insert into people(first_name, last_name, age)
values ('Tina', 'Belcher', 13);

insert into people(first_name, last_name, age)
values ('Bob', 'Belcher', 47);

insert into people(first_name, last_name, age)
values ('Linda', 'Belcher', 45),
		('Phillip', 'Frond', 38),
        ('Calvin', 'Fischoeder', 70);

select * from people;

drop table people;

create table employees(
	id int auto_increment,
    last_name varchar(100) not null,
	first_name varchar(100) not null,
    middle_name varchar(100),
    age int not null,
    current_status varchar(100) not null default 'employed',
    primary key(id)
);

desc employees;

INSERT INTO employees(first_name, last_name, age) VALUES
('Dora', 'Smith', 58);

select * from employees;

drop table employees;

UPDATE cats SET name = 'Jack' WHERE name = 'Jackson';

UPDATE cats SET breed = 'British Shorthair' WHERE name = 'Ringo';

update cats set age = 12 where breed = 'Maine Coon';

delete from cats where age = 4;

delete from cats where cat_id = age;

delete from cats;