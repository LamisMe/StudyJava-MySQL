create database ss5_indexs_store_procedure_views;

use ss5_indexs_store_procedure_views;

create table products(
	id int primary key auto_increment,
    product_code int unique,
    product_name varchar(50) not null,
    product_price int not null,
    product_amount int ,
    product_description varchar(255),
    product_status varchar(45) not null
);

insert into products(product_code,product_name,product_price,product_amount,product_description,product_status)
values (1,"Miranda",10000,10,"There's no flavour like your flavour","Còn hàng"),
(2,"Coca-Cola",10000,20,"Uống cùng cảm xúc","Còn hàng"),
(3,"7UP",10000,20,"Get Down, 7Up","Còn hàng");

insert into products(product_code,product_name,product_price,product_description,product_status)
values (4,"Rock-Star",10000,"Đánh thức bản lĩnh","Hết hàng");

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào

create unique index unique_index
on products(product_code);

create index composite_index
on products(product_name,product_price);

explain select *
from products
where product_name = "7UP";

drop index unique_index
on products;

-- So sánh câu truy vấn trước và sau khi tạo index
-- Trước khi tạo index thì phải truy vấn qua 4 rows mới tìm được sản phẩm
-- Sau khi tạo index thì chỉ cần truy vấn qua 1 rows là  tìm được sản phẩm


-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.

create view  view_product as
select products.product_code,products.product_name,products.product_price,products.product_status
from products;

-- Tiến hành sửa đổi view

create or replace view view_product as
select products.product_name,products.product_price,products.product_status
from products;

-- Tiến hành xoá view

drop view view_product;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product

delimiter $$
create procedure get_all_product (in search_name varchar(50))
begin
select *
from products
where product_name = search_name ;
end $$
delimiter ;

call get_all_product("7UP");

-- Tạo store procedure thêm một sản phẩm mới

delimiter $$
create procedure add_product (
in id int,
product_code int,
product_name varchar(50),
product_price int,
product_amount int,
product_description varchar(255),
product_status varchar(45))
begin
insert into products 
values(id,product_code,product_name,product_price,product_amount,product_description,product_status);
end $$
delimiter $$

call add_product(5,5,"C2",10000,10,"cool & clean","Còn hàng");

select products.product_code,products.product_name
from products;

-- Tạo store procedure sửa thông tin sản phẩm theo id

delimiter $$
create procedure update_product(
in search_id int,
new_product_code int,
new_product_name varchar(50),
new_product_price int,
new_product_amount int,
new_product_description varchar(255),
new_product_status varchar(45))
begin
update products
set product_code = new_product_code,
	product_name = new_product_name,
    product_price = new_product_price,
    product_amount = new_product_amount,
    product_description = new_product_description,
    product_status = new_product_status
where id = search_id;
end $$
delimiter ;

call update_product(5,5,"C2",10000,10,"cool & clean","Còn hàng");
-- Tạo store procedure xoá sản phẩm theo id

delimiter $$
create procedure delete_product(in search_id int)
begin
delete
from products
where id = search_id;
end $$
delimiter ;

call delete_product(5);