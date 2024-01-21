create database luyen_tap_crud;

use luyen_tap_crud;

create table loai_bai_hoc(
ma_loai_bai_hoc int primary key auto_increment,
ten_loai_bai_hoc varchar(45)
);

create table bai_hoc(
ma_bai_hoc int primary key auto_increment,
ma_loai_bai_hoc int,
foreign key(ma_loai_bai_hoc) references loai_bai_hoc(ma_loai_bai_hoc),
do_kho int,
module int,
link varchar(45),
trang_thai_xoa bit(1) default 0
);

insert into loai_bai_hoc(ten_loai_bai_hoc)
values('Java Script'),
('Java core'),
('Java FE'),
('Java BE'),
('Data Base'),
('NodeJS');

insert into bai_hoc(ma_loai_bai_hoc,do_kho,module,link)
values (1,2,1,'https:javascript.codegymdanang.com'),
(5,2,3,'https:database.codegymdanang.com'),
(2,3,2,'https:javacore.codegymdanang.com'),
(3,3,3,'https:javafe.codegymdanang.com'),
(4,3,3,'https:javabe.codegymdanang.com'),
(6,3,5,'https:nodejs.codegymdanang.com'); 

update bai_hoc set ma_loai_bai_hoc = 3 ,do_kho = 2, module = 1,link = 'hi' where ma_bai_hoc = 7;