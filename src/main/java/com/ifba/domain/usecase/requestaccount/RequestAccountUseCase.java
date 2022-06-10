package com.ifba.domain.usecase.requestaccount;

import com.ifba.domain.entity.RequestAccount;
import com.ifba.domain.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RequestAccountUseCase {

    private final IRepositoryRequestAccount iRepositoryRequestAccount;
    private final BlockRequests blockRequests;

    //injetado via controlador
    public RequestAccountUseCase(IRepositoryRequestAccount iRepositoryRequestAccount, BlockRequests blockRequests) {
        this.iRepositoryRequestAccount = iRepositoryRequestAccount;
        this.blockRequests = blockRequests;
    }

    public RequestAccount saveRequestAccount(RequestAccount requestAccount){
        blockRequests.blockDuplicateAttributes(requestAccount.getCpf(),requestAccount.getUserRequest().getUsername());
        blockRequests.blockNonexistentRole(requestAccount.getRole());
        return iRepositoryRequestAccount.save(requestAccount);
    }

    public List<RequestAccount> findAllRequestAccount(){
        return iRepositoryRequestAccount.findAll();
    }

    public void deleteAllRequesAccount(){
        iRepositoryRequestAccount.deleteAll();
    }

    public RequestAccount findRequestAccountByCpf(String cpf){
        return iRepositoryRequestAccount.findByCpf(cpf);
    }

    //TODO vale a pena deixar no caso de uso ? Pois nao é exatamente um caso de uso... Eis a questao

}
