package com.ifba.domain.usecase.login;

import com.ifba.application.exception.exceptions.UniversalErro;
import com.ifba.config.enuns.BasicEnum;
import com.ifba.config.enuns.ErroEnum;
import com.ifba.config.modelmapper.loginentityconvert.LoginEntityConvert;
import com.ifba.domain.dto.loginentity.LoginEntity;
import com.ifba.domain.entity.Student;
import com.ifba.domain.entity.Teacher;
import com.ifba.domain.entity.User;
import com.ifba.domain.repository.IRepositoryStudent;
import com.ifba.domain.repository.IRepositoryTeacher;
import com.ifba.domain.repository.IRepositoryUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginUseCase {

    private final LoginEntityConvert loginEntityConvert;
    private final IRepositoryUser iRepositoryUser;
    private final IRepositoryStudent iRepositoryStudent;
    private final IRepositoryTeacher iRepositoryTeacher;
    private User user;
    public LoginUseCase(LoginEntityConvert loginEntityConvert, IRepositoryUser iRepositoryUser, IRepositoryStudent iRepositoryStudent, IRepositoryTeacher iRepositoryTeacher) {
        this.loginEntityConvert = loginEntityConvert;
        this.iRepositoryUser = iRepositoryUser;
        this.iRepositoryStudent = iRepositoryStudent;
        this.iRepositoryTeacher = iRepositoryTeacher;
    }

    public LoginEntity findUser(String username, String password) {
        if (iRepositoryUser.findByUsername(username) == null)
            throw new UniversalErro(ErroEnum.USERNAME_INVALID);
        User user = iRepositoryUser.findByUsernameAndPassword(username, password);
        if (user == null)
            throw new UniversalErro(ErroEnum.USERNAME_PASSWORD_INVALID);
        LoginEntity loginEntity = new LoginEntity();
        this.user = user;
        if (user.getRole().equals(BasicEnum.STUDENT.getDescription())){
            loginEntity =  loginEntityConvert.studentToLoginEntity(findUserStudent());
        }
        if (user.getRole().equals(BasicEnum.TEACHER.getDescription())){
            loginEntity = loginEntityConvert.teacherToLoginEntity(findUserTeacher());
        }
        return loginEntity;
    }

    public Student findUserStudent(){
        return iRepositoryStudent.findByUserId(this.user.getId());
    }


    public Teacher findUserTeacher(){
        return iRepositoryTeacher.findByUserId(this.user.getId());
    }

}
