-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống 
-- có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.

use case_study_db;

select *
from nhan_vien
where (substring_index(ho_ten," ",1) like 'H%' or substring_index(ho_ten," ",1) like 'T%' or substring_index(ho_ten," ",1) like 'K%') and char_length(ho_ten) <= 15;

-- 3.Hiển thị thông tin của tất cả khách hàng 
-- có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

