package com.ifba.domain.repository;

import com.ifba.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryTeacher extends JpaRepository<Teacher,Long> {

    Teacher findByCpf(String cpf);
}
