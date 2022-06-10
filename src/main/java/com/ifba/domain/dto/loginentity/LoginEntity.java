package com.ifba.domain.dto.loginentity;

import com.ifba.domain.entity.User;
import com.ifba.domain.entity.Wallet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginEntity {

    private String name;
    private String cpf;
    private Wallet wallet;
    private User user;

}
