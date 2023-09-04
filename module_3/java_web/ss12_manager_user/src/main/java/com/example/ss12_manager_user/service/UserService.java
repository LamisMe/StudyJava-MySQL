package com.example.ss12_manager_user.service;

import com.example.ss12_manager_user.model.User;
import com.example.ss12_manager_user.repository.IUserDao;
import com.example.ss12_manager_user.repository.UserDao;

import java.util.List;

public class UserService implements IUserService{
    private final IUserDao userDao = new UserDao();
    @Override
    public List<User> search(String name) {
        return userDao.findByCountry("%"+name+"%");
    }

    @Override
    public void addUserTransaction(User user) {
        userDao.addUserTransaction(user);
    }
}
