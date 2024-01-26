package com.example.quan_ly_nong_trai_heo.service;

import com.example.quan_ly_nong_trai_heo.model.Location;
import com.example.quan_ly_nong_trai_heo.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService implements ILocationService {
    @Autowired
    private ILocationRepository locationRepository;
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }
}
