package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<BlogEntity,Integer> {
    @Query(value = "select * from blogs where category_id =:categories",nativeQuery = true)
    List<BlogEntity> searchBlogByCategory(@Param("categories") int categories);
    @Query(value = "select * from blogs where author like:author",nativeQuery = true)
    Page<BlogEntity> searchByAuthor(Pageable pageable,@Param("author") String searchByAuthor);

}
