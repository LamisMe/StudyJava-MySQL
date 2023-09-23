package com.example.ss6_app_blog.repository;

import com.example.ss6_app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update blog set " +
            "blog.name =:name," +
            "blog.author =:author," +
            "blog.title =:title," +
            "blog.content =:content," +
            "blog.blogging_day =:bloggingDay where blog.id =:id",nativeQuery = true)
    void updateBlog(@Param("name") String name,@Param("author") String author,@Param("title") String title,@Param("content") String content,
                    @Param("bloggingDay") String bloggingDay,@Param("id") Integer id);
    @Query(value = "select b from Blog b where b.name =:name or b.author =:author or b.title =:title")
    Page<Blog> findAllByNameOrAuthorOrTitle(Pageable pageable, @Param("name") String name, @Param("author") String author, @Param("title") String title);

    @Query(value = "select * from blog b where b.category_id =:category ",nativeQuery = true)
    Page<Blog> findAllByBlog(Pageable pageable, @Param("category") int category);
    Page<Blog> findAllByNameContaining(Pageable pageable,String searchName);
}
