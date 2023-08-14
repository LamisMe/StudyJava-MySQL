create database ss3_quan_ly_ban_hang;

use ss3_quan_ly_ban_hang;

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
    product_price int
);

create table order_detail(
	order_id int,
    product_id int,
	primary key(order_id,product_id),
	foreign key(order_id) references `orders`(order_id),
    foreign key(product_id) references products(product_id),
    order_quantity int
);

-- Thêm dữ liệu

insert into customers(customer_name,customer_age) 
values ("Minh Quan",10),("Ngoc Oanh",20),("Hong Ha",50);

insert into orders(customer_id,order_date)
values (1, '2006-03-21'), (2, '2006-03-23'), (1, '2006-03-16');

insert into products(product_name,product_price)
values ("May Giat",3),("Tu Lanh",5),("Dieu Hoa",7),("Quat",1),("Bep Dien",2);

insert into order_detail
values (1,1,3),(1,3,7),(1,4,2),(2,1,1),(3,1,8),(2,5,4),(2,3,3);

-- Truy Vấn

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order

select `orders`.order_id,`orders`.order_date,`orders`.order_total_price
from `orders`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách

select customers.customer_name ,products.product_name,order_detail.order_quantity
from customers
left join `orders` on `orders`.customer_id = customers.customer_id
join order_detail on order_detail.order_id = `orders`.order_id
join products on products.product_id = order_detail.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select customers.customer_name 
from customers
left join `orders` on customers.customer_id = `orders`.customer_id
where orders.customer_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán
--  của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)

select od.order_id, o.order_date, SUM(od.order_quantity * p.product_price) as total_price
from `orders` o
join order_detail od on od.order_id = o.order_id
join products p on p.product_id = od.product_id
group by od.order_id;