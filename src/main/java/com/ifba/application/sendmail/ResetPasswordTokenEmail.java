package com.ifba.application.sendmail;

import com.ifba.domain.entity.User;
import org.springframework.mail.SimpleMailMessage;

import java.util.Locale;

public class ResetPasswordTokenEmail {

    private SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?token=" + token;
        return constructEmail("Reset Password", "asdasddas" + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body,
                                             User user) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("2rcmfoda@gmail.com");
        msg.setSubject("Nova inscrição pendente!");
        msg.setText("Nome: "
                + "\nUltimo nome: "
                + "\nCpf:"
                + "\nPerfil:");
        return msg;
    }

}
