SQL code homework 16

DROP DATABASE if exists store;

CREATE DATABASE if not exists store;

USE store;

CREATE TABLE countries(
code int primary key,
name varchar(20) unique,
contient_name varchar(20) unique
);

CREATE TABLE users(
id int primary key AUTO_INCREMENT,
full_name varchar(20) not null,
email varchar(20) not null unique,
gender char(1) check(gender='m' or gender='f') not null,
date_of_birth varchar(15) not null,
created_at datetime DEFAULT NOW(),
country_code int,
FOREIGN KEY (country_code) references countries(code)
);

CREATE TABLE orders(
id int primary key AUTO_INCREMENT,
user_id int,
FOREIGN KEY (user_id) references users(id),
status varchar(6) check(status='star' or status='finish'),
created_at datetime	DEFAULT NOW()
);

CREATE TABLE products(
id int primary key AUTO_INCREMENT,
name varchar(10) not null,
price int default 0,
status varchar(10) check(status='valid' or status='expired'),
created_at datetime	DEFAULT NOW()
);

CREATE TABLE order_products(
order_id int,
FOREIGN KEY (order_id) references orders(id) on DELETE set null,
product_id int,
FOREIGN KEY (product_id) references products(id) ON DELETE CASCADE,
quantity int default 0
);


INSERT into countries values (1,"Saudi Arabia","KSA");

INSERT into users (full_name,email,gender,date_of_birth,country_code) values ("Abdullah","abodi.imz@gmail.com",'m','1999-3-31',1);

INSERT into orders (user_id, status) values (1,"star");

INSERT into products (name,price,status) values ("Laptop",15000,"valid");

INSERT into order_products values (1,1,1);

UPDATE countries set contient_name="SA" where code=1;

DELETE from products where id=1;

SELECT * from countries;

SELECT * from users;

SELECT * from orders;

SELECT * from products;

SELECT * from order_products;




