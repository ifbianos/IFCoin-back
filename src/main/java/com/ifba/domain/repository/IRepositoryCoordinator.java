package com.ifba.domain.repository;

import com.ifba.domain.entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCoordinator extends JpaRepository<Coordinator, Long> {
    Coordinator findByCpf(String cpf);
}
