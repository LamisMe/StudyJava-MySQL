package com.example.demo_send_mail.service;

import com.example.demo_send_mail.repository.ISendEmail;
import com.example.demo_send_mail.repository.SendMailRepository;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class SendMailService implements ISendEmailService {
    private ISendEmail sendEmail = new SendMailRepository();

    public void send(String to, String sub, String msg, final String user, final String pass) {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        properties.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, pass);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setContent(msg, "text/html;charset=UTF-8");

            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String email(String email) {

        return sendEmail.email(email);
    }

    public StringBuilder codeRandom() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int num = (int) Math.floor(Math.random() * 10);
            code.append(num);
        }
        return code;
    }
}
