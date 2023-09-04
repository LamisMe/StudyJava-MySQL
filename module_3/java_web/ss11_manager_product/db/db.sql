create database ss11_product;

use ss11_product;

create table products(
id int primary key auto_increment,
`name` varchar(50),
price int,
`description` varchar(245),
supplier varchar(45),
`status` bit(1) default 0
);

insert into products(`name`,price,`description`,supplier)
values ("Americano",60000,"good","Highlands"),
("Capuchino",50000,"very-much","Highlands"),
("Cafe fin",29000,"very-much","Highlands");

update products
set status = 1
where id = 1;