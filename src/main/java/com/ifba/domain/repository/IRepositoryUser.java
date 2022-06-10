package com.ifba.domain.repository;

import com.ifba.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryUser extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
