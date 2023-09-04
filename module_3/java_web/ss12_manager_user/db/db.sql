CREATE DATABASE ss12_manager_user;
USE ss12_manager_user; 
create table users ( 
      id int(3) NOT NULL AUTO_INCREMENT, 
      name varchar(120) NOT NULL, 
      email varchar(220) NOT NULL, 
      country varchar(120), 
      PRIMARY KEY (id),
      status bit(1) default 0
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users order by name;

select * from users where country like "%%";

-- truy vấn
delimiter $$
create procedure show_all()
begin 
select *
from users
where status = 0;
end $$
delimiter ;


-- thêm mới
delimiter $$
create procedure add_user(new_name varchar(120), new_email varchar(220), new_country varchar(120))
begin 
insert into users(name, email, country)
values (new_name, new_email, new_country);
end $$
delimiter ;


-- xóa

delimiter $$
create procedure delete_user(delete_id int)
begin 
update users 
set status = 1
where id = delete_id;
end $$
delimiter ;

-- cập nhật

delimiter $$
create procedure update_user(update_id int,new_name varchar(120), new_email varchar(220), new_country varchar(120))
begin 
update users 
set 
name = new_name,
email = new_email,
country = new_country
where id = update_id;
end $$
delimiter ;

call show_all();

call add_user("Hoang","hoang@codegym.com","Viet Nam");