package com.ifba.domain.usecase.requestaccount;

import com.ifba.application.exception.exceptions.UniversalErro;
import com.ifba.config.enuns.ErroEnum;
import com.ifba.config.enuns.BasicEnum;
import com.ifba.domain.repository.*;
import org.springframework.stereotype.Service;


@Service
public class BlockRequests {

    private final IRepositoryRequestAccount iRepositoryRequestAccount;
    private final IRepositoryStudent iRepositoryStudent;
    private final IRepositoryTeacher iRepositoryTeacher;
    private final IRepositoryCoordinator iRepositoryCoordinator;
    private final IRepositoryStore iRepositoryStore;
    private final IRepositoryUser iRepositoryUser;
    private final IRepositoryUserRequest iRepositoryUserRequest;

    //injetado via controlador
    public BlockRequests(IRepositoryRequestAccount iRepositoryRequestAccount, IRepositoryStudent iRepositoryStudent, IRepositoryTeacher iRepositoryTeacher, IRepositoryCoordinator iRepositoryCoordinator, IRepositoryStore iRepositoryStore, IRepositoryUser iRepositoryUser, IRepositoryUserRequest iRepositoryUserRequest) {
        this.iRepositoryRequestAccount = iRepositoryRequestAccount;
        this.iRepositoryStudent = iRepositoryStudent;
        this.iRepositoryTeacher = iRepositoryTeacher;
        this.iRepositoryCoordinator = iRepositoryCoordinator;
        this.iRepositoryStore = iRepositoryStore;
        this.iRepositoryUser = iRepositoryUser;
        this.iRepositoryUserRequest = iRepositoryUserRequest;
    }

    public void blockDuplicateAttributes(String cpf,String username){
        if(iRepositoryRequestAccount.findByCpf(cpf) != null
                || iRepositoryStudent.findByCpf(cpf)  != null
                || iRepositoryTeacher.findByCpf(cpf)  != null
                || iRepositoryCoordinator.findByCpf(cpf)  != null
                || iRepositoryStore.findByCpf(cpf)  != null
                || iRepositoryStore.findByCpf(cpf)  != null
        )
            throw new UniversalErro(ErroEnum.DUPLICATE_CPF);

        if(iRepositoryUserRequest.findByUsername(username) != null
                || iRepositoryUser.findByUsername(username)  != null
        )
            throw new UniversalErro(ErroEnum.DUPLICATE_USERNAME);
    }

    public void blockNonexistentRole(String role){
        if(role == null)
            throw new UniversalErro(ErroEnum.WRONG_ROLE);
        if(!role.equals(BasicEnum.STUDENT.getDescription())
                && !role.equals(BasicEnum.TEACHER.getDescription())
                && !role.equals(BasicEnum.STORE.getDescription())
        )
            throw new UniversalErro(ErroEnum.WRONG_ROLE);
    }
}
