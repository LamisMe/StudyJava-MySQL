use bonus_exercise;

-- 1. Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào (chỉ học viên có lớp học).

select *
from student ;

select *
from student
where class_id ;

select *
from student
join class on student.class_id = class.id;

select *
from class
where name like "%";

-- 2 Lấy ra thông tin các học viên, và cho biết các học viên đang theo học lớp nào và cả các bạn đã đăng ký nhưng chưa có lớp học.
-- select s.*,ifnull(c.name,"chưa có lớp học") as class_name
-- from student s
-- left join class c on s.class_id = c.id;

-- select *
-- from student
-- where  student.class_id is not null ;