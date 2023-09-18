package com.ss3_exercise_1.repository;

import com.ss3_exercise_1.model.Email;

import java.util.List;

public interface IEmailRepository {
    void settingsMail(Email email);
    Email getEmail();
}
