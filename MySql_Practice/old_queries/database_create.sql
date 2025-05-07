create database employee;

use employee;

describe employee;

create table employee(
	id int auto_increment primary key,
    name varchar(20)
);

insert into employee(id,name) values (1,"kumar"),(2,"srinath");

select * from employee;

create database project;

create database mapping;

create database onetomany;

create database springjpa;

create database user_management;

create database department_db;

create database employee_db;