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

    //injetado via controlador
    public BlockRequests(IRepositoryRequestAccount iRepositoryRequestAccount, IRepositoryStudent iRepositoryStudent, IRepositoryTeacher iRepositoryTeacher, IRepositoryCoordinator iRepositoryCoordinator, IRepositoryStore iRepositoryStore) {
        this.iRepositoryRequestAccount = iRepositoryRequestAccount;
        this.iRepositoryStudent = iRepositoryStudent;
        this.iRepositoryTeacher = iRepositoryTeacher;
        this.iRepositoryCoordinator = iRepositoryCoordinator;
        this.iRepositoryStore = iRepositoryStore;
    }

    public void blockDuplicateAttributes(String cpf){
        if(iRepositoryRequestAccount.findByCpf(cpf) != null
                || iRepositoryStudent.findByCpf(cpf)  != null
                || iRepositoryTeacher.findByCpf(cpf)  != null
                || iRepositoryCoordinator.findByCpf(cpf)  != null
                || iRepositoryStore.findByCpf(cpf)  != null
        )
            throw new UniversalErro(ErroEnum.DUPLICATE_CPF);
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
