package com.example.quan_ly_nong_trai_heo.service;

import com.example.quan_ly_nong_trai_heo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPigService {
    Page<Pig> findAllPig(Pageable pageable,String location,boolean status,String pigId);
    Page<Pig> findAllPig(Pageable pageable,boolean status,String pigId);
    void deletePig(int id);
    void updatePig(Pig pig);
    boolean createPig(Pig pig);
    Pig findById(int id);
}
