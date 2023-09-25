package com.example.ss6_app_blog.model;

import org.hibernate.mapping.UniqueKey;
import org.springframework.boot.context.properties.bind.Name;
import org.thymeleaf.util.DateUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String author;
    private String title;
    @Column(columnDefinition = "text",nullable = false)

    private String content;

    @Column(columnDefinition = "date")

    private String bloggingDay;
    @ManyToOne
    @JoinColumn(columnDefinition = "category_id", referencedColumnName = "id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(int id, String name, String author, String title, String content, String bloggingDay) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.title = title;
        this.content = content;
        this.bloggingDay = bloggingDay;
    }

    public Blog(int id, String name, String author, String title, String content, String bloggingDay, Category category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.title = title;
        this.content = content;
        this.bloggingDay = bloggingDay;
        this.category = category;
    }

    public Blog(String name, String author, String title, String content, String bloggingDay, Category category) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.content = content;
        this.bloggingDay = bloggingDay;
        this.category = category;
    }

    public Blog(String name, String author, String title, String content, String bloggingDay) {
        this.name = name;
        this.author = author;
        this.title = title;
        this.content = content;
        this.bloggingDay = bloggingDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBloggingDay() {
        return bloggingDay;
    }

    public void setBloggingDay(String bloggingDay) {
        this.bloggingDay = bloggingDay;
    }

    public String getBloggingDayLocalDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(bloggingDay, dateTimeFormatter).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
