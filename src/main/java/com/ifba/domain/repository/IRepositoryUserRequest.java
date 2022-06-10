package com.ifba.domain.repository;

import com.ifba.domain.entity.User;
import com.ifba.domain.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUserRequest extends JpaRepository<UserRequest,Long> {
    UserRequest findByUsername(String username);
}
