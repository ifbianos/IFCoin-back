package com.ifba.domain.repository;

import com.ifba.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User,Long> {
}
