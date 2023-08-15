create database ss4_quan_ly_sinh_vien;

use ss4_quan_ly_sinh_vien;

create table lop(
	ma_lop int not null auto_increment primary key,
    ten_lop varchar(60) not null,
    ngay_bat_dau datetime not null,
    trang_thai bit
);

create table sinh_vien(
	ma_sinh_vien int not null auto_increment primary key,
    ten_sinh_vien varchar(30) not null,
    dia_chi varchar(50),
    so_dien_thoai varchar(20),
    trang_thai bit,
    ma_lop int not null,
    foreign key(ma_lop) references lop(ma_lop)
);

create table mon_hoc(
	ma_mon_hoc int not null auto_increment primary key,
    ten_mon_hoc varchar(30) not null,
    diem_mon_hoc tinyint not null default 1 check (diem_mon_hoc >= 1),
    trang_thai bit default 1
);

create table diem_mon_hoc(
	ma_diem_mon_hoc int not null auto_increment primary key,
    ma_mon_hoc int not null,
    ma_sinh_vien int not null,
    diem_mon_hoc float default 0 check (diem_mon_hoc between 0 and 100),
    so_lan_lam_bai_kiem_tra tinyint default 1,
    unique(ma_mon_hoc,ma_sinh_vien),
    foreign key(ma_mon_hoc) references mon_hoc(ma_mon_hoc),
    foreign key(ma_sinh_vien) references sinh_vien(ma_sinh_vien)  
);

-- Thêm dữ liệu

insert into lop
values (1, 'A1', '2008-12-20', 1);
insert into lop
values (2, 'A2', '2008-12-22', 1);
insert into lop
values (3, 'B3', current_date, 0); 

insert into sinh_vien (ten_sinh_vien, dia_chi, so_dien_thoai, trang_thai, ma_lop)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into sinh_vien (ten_sinh_vien, dia_chi,trang_thai, ma_lop)
values ('Hoa', 'Hai phong', 1, 1);
insert into sinh_vien (ten_sinh_vien, dia_chi, so_dien_thoai, trang_thai, ma_lop)
values ('Manh', 'HCM', '0123123123', 0, 2);

insert into mon_hoc
values (1, 'CF', 5, 1),
 (2, 'C', 6, 1),
 (3, 'HDJ', 5, 1),
 (4, 'RDBMS', 10, 1);
 
insert into diem_mon_hoc (ma_mon_hoc, ma_sinh_vien, diem_mon_hoc, so_lan_lam_bai_kiem_tra)
values (1, 1, 8, 1),
 (1, 2, 10, 2),
 (2, 1, 12, 1);
 
--  Truy vấn

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.

select *
from mon_hoc
where diem_mon_hoc in (
select max(diem_mon_hoc) from mon_hoc);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.

select mon_hoc.ten_mon_hoc,diem_mon_hoc.diem_mon_hoc as 'diem_thi_lon_nhat'
from mon_hoc
left join diem_mon_hoc on diem_mon_hoc.ma_mon_hoc = mon_hoc.ma_mon_hoc
where diem_mon_hoc.diem_mon_hoc in (select max(diem_mon_hoc) from diem_mon_hoc);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select sinh_vien.ma_sinh_vien,sinh_vien.ten_sinh_vien,sinh_vien.dia_chi,sinh_vien.so_dien_thoai,avg(diem_mon_hoc) as 'diem_trung_binh'
from sinh_vien
left join diem_mon_hoc on  diem_mon_hoc.ma_sinh_vien = sinh_vien.ma_sinh_vien
group by sinh_vien.ma_sinh_vien
order by diem_mon_hoc desc, ten_sinh_vien ;
