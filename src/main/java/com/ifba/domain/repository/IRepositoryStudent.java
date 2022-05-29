package com.ifba.domain.repository;

import com.ifba.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryStudent extends JpaRepository< Student,Long> {

    Student findByCpf(String cpf);

}
