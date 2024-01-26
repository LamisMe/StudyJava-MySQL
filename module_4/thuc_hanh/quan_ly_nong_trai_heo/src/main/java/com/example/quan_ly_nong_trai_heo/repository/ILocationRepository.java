package com.example.quan_ly_nong_trai_heo.repository;

import com.example.quan_ly_nong_trai_heo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location,Integer> {
}
