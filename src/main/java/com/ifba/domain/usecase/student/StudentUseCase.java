package com.ifba.domain.usecase.student;

import com.ifba.domain.entity.Student;
import com.ifba.domain.repository.IRepositoryStudent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentUseCase {

    private final IRepositoryStudent iRepositoryStudent;

    public StudentUseCase(IRepositoryStudent iRepositoryStudent) {
        this.iRepositoryStudent = iRepositoryStudent;
    }

    public List<Student> findStudentByContainingString(String containing){
        return containing.isEmpty() ? null :
         iRepositoryStudent.findByNameContainingIgnoreCaseOrderByNameAsc(containing);
    }
}
