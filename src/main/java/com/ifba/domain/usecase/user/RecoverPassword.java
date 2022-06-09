package com.ifba.domain.usecase.user;


import com.ifba.domain.entity.PasswordToken;
import com.ifba.domain.entity.User;
import com.ifba.domain.repository.IRepositoryPasswordToken;
import com.ifba.domain.repository.IRepositoryUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class RecoverPassword {

    private final IRepositoryUser iRepositoryUser;
    private final IRepositoryPasswordToken iRepositoryPasswordToken;

    public RecoverPassword(IRepositoryUser iRepositoryUser, IRepositoryPasswordToken iRepositoryPasswordToken) {
        this.iRepositoryUser = iRepositoryUser;
        this.iRepositoryPasswordToken = iRepositoryPasswordToken;
    }

    User findByEmail(String cpf){
       return iRepositoryUser.findByEmail(cpf);
    }

    public void createPasswordResetTokenForUser(String cpf){
        if(findByEmail(cpf)!= null){
            log.info("entrou aqui");
            String token = UUID.randomUUID().toString();
            PasswordToken myToken = new PasswordToken(token, findByEmail(cpf));
            iRepositoryPasswordToken.save(myToken);
        }
    }
}
