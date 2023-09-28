package com.example.ung_dung_muon_sach.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int countOfBooks = 0;
    private static int countPeoPleVisit = 0;
    @After("execution(* com.example.ung_dung_muon_sach.controller.BookController.*Book(..))")
    public void countChangeBookStatus(){
        countOfBooks++;
        System.out.println("Các hành động khiến trạng thái sách của thư viện bị thay đổi :" + countOfBooks);
    }

    @After("execution(* com.example.ung_dung_muon_sach.controller.*Controller.*(..))")
    public void countPeopleVisitLibrary (){
        countPeoPleVisit++;
        System.out.println("Số lượng người đã ghé thăm thư viện sách :" + countPeoPleVisit);
    }
}
