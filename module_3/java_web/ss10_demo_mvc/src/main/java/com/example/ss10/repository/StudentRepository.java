package com.example.ss10.repository;

import com.example.ss10.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> list;
    static {
        list = new ArrayList<>();
        list.add(new Student(5,"Thanh Hải", true, 5));
        list.add(new Student(6,"Mỹ Liên", false, 6));
        list.add(new Student(7,"Mỹ Hạnh", false, 7));
        list.add(new Student(8,"Hữu Hậu", true, 8));
    }
    @Override
    public List<Student> showList() {
        return list;
    }
}
