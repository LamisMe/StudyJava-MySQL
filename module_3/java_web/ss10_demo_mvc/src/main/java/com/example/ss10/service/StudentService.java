package com.example.ss10.service;

import com.example.ss10.model.Student;
import com.example.ss10.repository.IStudentRepository;
import com.example.ss10.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository iStudentRepository = new StudentRepository();
    @Override
    public List<Student> showList() {
        return iStudentRepository.showList();
    }
}
