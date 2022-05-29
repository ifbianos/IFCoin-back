package com.ifba.domain.repository;

import com.ifba.domain.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUserRequest extends JpaRepository<UserRequest,Long> {
}
