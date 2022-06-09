package com.ifba.domain.repository;

import com.ifba.domain.entity.PasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRepositoryPasswordToken extends JpaRepository<PasswordToken,Long> {
}
