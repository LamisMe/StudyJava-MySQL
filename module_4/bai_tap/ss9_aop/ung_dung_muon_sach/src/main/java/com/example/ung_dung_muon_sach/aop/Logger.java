package com.example.ung_dung_muon_sach.aop;

import com.example.ung_dung_muon_sach.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class Logger {
    private int countOfBooks = 0;
    private int countPeoPleVisit = 0;
    @After("execution(* com.example.ung_dung_muon_sach.controller.BookController.*Book(..))")
    public void countChangeBookStatus(JoinPoint joinPoint) throws IOException {
        countOfBooks++;
        System.out.println("Các hành động khiến trạng thái sách của thư viện bị thay đổi :" + countOfBooks);
    }

    @After("execution(* com.example.ung_dung_muon_sach.controller.*Controller.*(..))")
    public void countPeopleVisitLibrary (){
        countPeoPleVisit++;
        System.out.println("Số lượng người đã ghé thăm thư viện sách :" + countPeoPleVisit);
    }
}
