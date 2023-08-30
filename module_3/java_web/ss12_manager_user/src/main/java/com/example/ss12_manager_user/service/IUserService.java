package com.example.ss12_manager_user.service;

import com.example.ss12_manager_user.model.User;

import java.util.List;

public interface IUserService {
    List<User> search(String name);
}
