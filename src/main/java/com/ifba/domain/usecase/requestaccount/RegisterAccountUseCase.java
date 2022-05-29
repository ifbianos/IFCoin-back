package com.ifba.domain.usecase.requestaccount;

import com.ifba.application.exception.exceptions.UniversalErro;
import com.ifba.config.enuns.BasicEnum;
import com.ifba.config.enuns.ErroEnum;
import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.entity.RequestAccount;
import com.ifba.domain.entity.Student;
import com.ifba.domain.entity.Teacher;
import com.ifba.domain.repository.IRepositoryRequestAccount;
import com.ifba.domain.repository.IRepositoryStudent;
import com.ifba.domain.repository.IRepositoryTeacher;
import com.ifba.domain.repository.IRepositoryUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RegisterAccountUseCase {


    private final IRepositoryRequestAccount iRepositoryRequestAccount;
    private final IRepositoryStudent iRepositoryStudent;
    private final IRepositoryTeacher iRepositoryTeacher;
    private final ModelMapperConfig modelMapperConfig;
    private final BlockRequests blockRequests;

    public RegisterAccountUseCase(IRepositoryRequestAccount iRepositoryRequestAccount, IRepositoryStudent iRepositoryStudent,
                                  IRepositoryTeacher iRepositoryTeacher, IRepositoryUser iRepositoryUser, ModelMapperConfig modelMapperConfig, BlockRequests blockRequests) {
        this.iRepositoryRequestAccount = iRepositoryRequestAccount;
        this.iRepositoryStudent = iRepositoryStudent;
        this.iRepositoryTeacher = iRepositoryTeacher;
        this.modelMapperConfig = modelMapperConfig;
        this.blockRequests = blockRequests;
    }

    public RequestAccount findAccountByCpf(String cpf){
        if(iRepositoryRequestAccount.findByCpf(cpf) == null){
            throw new UniversalErro(ErroEnum.ACCOUNT_NOT_FOUND);
        }
        return iRepositoryRequestAccount.findByCpf(cpf);
    }

    public void deleteAccountByCpf(String cpf){
        iRepositoryRequestAccount.delete(findAccountByCpf(cpf));
    }

    public void registerAccount(String cpf){
        RequestAccount requestAccount = findAccountByCpf(cpf);
        String role = requestAccount.getRole();
        if(role.equals(BasicEnum.TEACHER.getDescription())){
            Teacher teacher = modelMapperConfig.modelMapper().map(requestAccount,Teacher.class);
            try{
                iRepositoryTeacher.save(teacher);
                iRepositoryRequestAccount.delete(requestAccount);
            }
            catch(Exception e){
                throw new UniversalErro(ErroEnum.SEMIDEIA);
            }
        }
        if(role.equals(BasicEnum.STUDENT.getDescription())){
            Student student = modelMapperConfig.modelMapper().map(requestAccount,Student.class);
            try{
                iRepositoryStudent.save(student);
                iRepositoryRequestAccount.delete(requestAccount);
            }
            catch(Exception e){
                throw new UniversalErro(ErroEnum.SEMIDEIA);
            }
        }

    }

}
