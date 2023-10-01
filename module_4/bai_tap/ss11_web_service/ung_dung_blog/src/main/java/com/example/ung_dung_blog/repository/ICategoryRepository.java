package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
