package com.ifba.domain.dto.requestaccount;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserRequestDto {

    @Size(min = 2, max = 32, message = "O Seu username deve ter entre 2 a 32 caracteres")
    private String username;
    @Size(min = 6, max = 32, message = "O Seu password deve ter entre 6 a 32 caracteres")
    private String password;
    @Email
    private String email;


}
