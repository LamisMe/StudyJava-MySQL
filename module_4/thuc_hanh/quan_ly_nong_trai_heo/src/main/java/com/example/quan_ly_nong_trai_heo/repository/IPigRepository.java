package com.example.quan_ly_nong_trai_heo.repository;

import com.example.quan_ly_nong_trai_heo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IPigRepository extends JpaRepository<Pig, Integer> {
    @Query(value = "select * from pigs" +
            " join locations on locations.id = pigs.location_id" +
            " where is_deleted = 0 and locations.`name` like :locationName " +
            " and pigs.status = :status and pigs.pig_id like :pigId ", nativeQuery = true)
    Page<Pig> findAllByPig(Pageable pageable, @Param("locationName") String locationName,
                           @Param("status") boolean status, @Param("pigId") String pigId);

    @Transactional
    @Query(value = "select * from pigs" +
            " join locations on pigs.location_id = locations.id " +
            " where is_deleted = 0 and " +
            " pigs.status =:status and pigs.pig_id like:pigId ", nativeQuery = true)
    Page<Pig> findAllBy(Pageable pageable, @Param("status") boolean status, @Param("pigId") String pigId);

    @Transactional
    @Modifying
    @Query(value = "update pigs set is_deleted = 1 where pigs.id =:idDelete", nativeQuery = true)
    void deletePigById(@Param("idDelete") int idDeleted);
}
