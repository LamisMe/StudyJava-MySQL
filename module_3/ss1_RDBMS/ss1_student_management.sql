create database ss1_student_managerment;

use ss1_student_managerment;

create table classroom(
		id int primary key auto_increment,
        `name` varchar(45)
);

create table teacher(
		id int primary key auto_increment,
        `name` varchar(45),
        age int,
        country varchar(45)
);

insert into classroom(`name`) 
values ("Lê Quang Toản"),("Đinh Thanh Hải"),("Kim Ngọc Thành"),("Trần Văn Lâm"),("Võ Nhân Trí");

insert into teacher(`name`,age,country)
values ("Trần Văn Chánh",38,"Việt Nam"),("Trương Tấn Hải",25,"Việt Nam"),("Nguyễn Công",32,"Việt Nam");

select *
from classroom;

select * 
from teacher;
