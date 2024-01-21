create database exam_module_3;
use exam_module_3;
create table loai_thuc_pham(
ma_loai_thuc_pham int auto_increment primary key,
ten_loai_thuc_pham varchar(45)
);

create table thuc_pham(
id int primary key auto_increment, 
ma_thuc_pham varchar(45),
ten_hang_thuc_pham varchar(45),
ngay_san_xuat date,
ngay_het_han date,
ma_loai_thuc_pham int,
foreign key(ma_loai_thuc_pham) references loai_thuc_pham(ma_loai_thuc_pham),
mo_ta_them varchar(245),
trang_thai_xoa bit(1) default 0
);


insert into loai_thuc_pham(ten_loai_thuc_pham)
values ('Hàng đông lạnh'),
('Hàng tươi sống'),
('Hàng đã qua chế biến');

insert into thuc_pham(ma_thuc_pham,ten_hang_thuc_pham,ngay_san_xuat,ngay_het_han,ma_loai_thuc_pham,mo_ta_them)
values (1,'Thịt đông lạnh','2022-12-12','2023-04-12',1,'N/a'),
(2,'Cá Thu','2023-01-30','2023-02-02',2,'N/a'),
(3,'Bánh bao hấp','2023-01-30','2023-03-25',3,'Hấp lại trong 5 phút'),
(4,'Rau xà lách','2022-02-01','2023-02-04',2,'N/a');