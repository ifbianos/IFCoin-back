package com.ifba.application.sendmail;

import com.ifba.domain.dto.requestaccount.RequestAccountDtoOut;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;

@Slf4j
public class MailBody {


    private SimpleMailMessage msg = new SimpleMailMessage();

    public MailBody(RequestAccountDtoOut dtoOut) {
        msg.setTo("2rcmfoda@gmail.com");
        msg.setSubject("Nova inscrição pendente!");
        msg.setText("Nome: "+ dtoOut.getName()
                    + "\nUltimo nome: " + dtoOut.getLastName()
                    + "\nCpf:" + dtoOut.getCpf()
                    + "\nPerfil:" + dtoOut.getRole());

    }

    public SimpleMailMessage sendEmail() {
        return this.msg;
    }



}
