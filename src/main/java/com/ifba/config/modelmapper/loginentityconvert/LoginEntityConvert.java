package com.ifba.config.modelmapper.loginentityconvert;

import com.ifba.config.modelmapper.ModelMapperConfig;
import com.ifba.domain.dto.loginentity.LoginEntity;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoIn;
import com.ifba.domain.dto.requestaccount.RequestAccountDtoOut;
import com.ifba.domain.entity.Student;
import com.ifba.domain.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class LoginEntityConvert {

    private final ModelMapperConfig modelMapperConfig;

    public LoginEntityConvert(ModelMapperConfig modelMapperConfig) {
        this.modelMapperConfig = modelMapperConfig;
    }

    public LoginEntity studentToLoginEntity(Student student){
        return modelMapperConfig.modelMapper().map(student,LoginEntity.class);
    }

    public LoginEntity teacherToLoginEntity(Teacher teacher){
        return modelMapperConfig.modelMapper().map(teacher,LoginEntity.class);
    }
}
