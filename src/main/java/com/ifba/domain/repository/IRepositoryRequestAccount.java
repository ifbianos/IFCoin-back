package com.ifba.domain.repository;

import com.ifba.domain.entity.RequestAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryRequestAccount extends JpaRepository<RequestAccount, Long> {

   RequestAccount findByCpf(String cpf);

}
