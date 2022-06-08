package com.ifba.domain.usecase.user;


import com.ifba.domain.entity.User;
import com.ifba.domain.repository.IRepositoryUser;
import org.springframework.stereotype.Service;

@Service
public class RecoverPassword {

    private final IRepositoryUser iRepositoryUser;

    public RecoverPassword(IRepositoryUser iRepositoryUser) {
        this.iRepositoryUser = iRepositoryUser;
    }

    User findByEmail(String cpf){
       return iRepositoryUser.findByEmail(cpf);
    }

    public void recoverPassword(String cpf){
        if(findByEmail(cpf)!= null){


        }
    }
}
