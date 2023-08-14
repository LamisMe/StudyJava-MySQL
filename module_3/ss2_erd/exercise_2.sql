create database ss2_erd_excercise_2;

use ss2_erd_excercise_2;

create table customers(
	customer_id int primary key auto_increment,
    customer_name varchar(45),
    customer_age int
);

create table `orders`(
	order_id int primary key auto_increment,
	customer_id int,
    foreign key(customer_id) references customers(customer_id),
    order_date date,
    order_total_price int
);

create table products(
	product_id int primary key auto_increment,
    product_name varchar(45),
    prouct_price int
);

create table order_detail(
	order_id int,
    product_id int,
	primary key(order_id,product_id),
	foreign key(order_id) references `orders`(order_id),
    foreign key(product_id) references products(product_id),
    order_quantity int
);