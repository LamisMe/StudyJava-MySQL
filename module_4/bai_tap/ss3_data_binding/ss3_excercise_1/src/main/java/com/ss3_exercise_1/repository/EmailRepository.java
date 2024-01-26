package com.ss3_exercise_1.repository;

import com.ss3_exercise_1.model.Email;
import org.springframework.stereotype.Repository;


@Repository
public class EmailRepository implements IEmailRepository{
    private Email email = new Email();
    @Override
    public void settingsMail(Email emailNew) {
            email = emailNew;
    }

    @Override
    public Email getEmail() {
        return email;
    }
}