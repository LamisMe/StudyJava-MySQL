package com.ss3_exercise_1.service;

import com.ss3_exercise_1.model.Email;
import com.ss3_exercise_1.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public void settingMail(Email email) {
        emailRepository.settingsMail(email);
    }

    @Override
    public Email getEmail() {
        return emailRepository.getEmail();
    }
}
