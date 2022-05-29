package com.ifba.domain.repository;

import com.ifba.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryStore extends JpaRepository<Store,Long> {
    Store findByCpf(String cpf);
}
