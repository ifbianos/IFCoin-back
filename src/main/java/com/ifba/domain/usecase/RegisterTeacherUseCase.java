package com.ifba.domain.usecase;

import com.ifba.domain.entity.Teacher;
import com.ifba.domain.repository.IRepositoryTeacher;

public class RegisterTeacherUseCase {

    private final IRepositoryTeacher iRepositoryTeacher;

    public RegisterTeacherUseCase(IRepositoryTeacher iRepositoryTeacher) {
        this.iRepositoryTeacher = iRepositoryTeacher;
    }

    public Teacher registerTeacher(Teacher teacher){
        return iRepositoryTeacher.save(teacher);
    }
}
