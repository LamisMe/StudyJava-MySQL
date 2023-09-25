package com.example.validate_form_dang_ky.sevice;

import com.example.validate_form_dang_ky.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    Page<User> findAll(Pageable pageable);
    void createUser(User user);
}
