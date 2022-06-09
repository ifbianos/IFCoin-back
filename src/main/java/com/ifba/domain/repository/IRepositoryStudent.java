package com.ifba.domain.repository;

import com.ifba.domain.entity.Student;
import com.ifba.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRepositoryStudent extends JpaRepository< Student,Long> {

    List<Student> findByNameContainingIgnoreCaseOrderByNameAsc(String containing);
    Student findByCpf(String cpf);

}
