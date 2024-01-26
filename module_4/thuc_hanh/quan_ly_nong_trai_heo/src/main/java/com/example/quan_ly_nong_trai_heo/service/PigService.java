package com.example.quan_ly_nong_trai_heo.service;

import com.example.quan_ly_nong_trai_heo.model.Pig;
import com.example.quan_ly_nong_trai_heo.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository pigRepository;

    @Override
    public Page<Pig> findAllPig(Pageable pageable, String location, boolean status, String pigId) {
        return pigRepository.findAllByPig(pageable, "%" + location + "%", status, "%" + pigId + "%");
    }

    @Override
    public Page<Pig> findAllPig(Pageable pageable, boolean status, String pigId) {
        return pigRepository.findAllBy(pageable,status, "%" + pigId + "%");
    }

    @Override
    public void deletePig(int id) {
        Pig pig = pigRepository.findById(id).get();
        if (pig != null) {
            pigRepository.deletePigById(id);
        }
    }

    @Override
    public void updatePig(Pig pig) {
        Pig pigEntity = pigRepository.findById(pig.getId()).get();
        if (pigEntity != null) {
            pigRepository.save(pigEntity);
        }
    }

    @Override
    public boolean createPig(Pig pig) {
        Pig pigEntity = pigRepository.save(pig);
        return pigEntity != null;
    }

    @Override
    public Pig findById(int id) {
        return pigRepository.findById(id).get();
    }
}
