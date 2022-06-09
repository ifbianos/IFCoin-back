package com.ifba.domain.dto.requestaccount;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Getter
@Setter
@Slf4j
public class RequestAccountDtoIn {

    @Size(min = 2, max = 32, message = "O Seu nome deve ter entre 2 a 32 caracteres")
    private String name;
    @Size(min = 2, max = 32, message = "O Seu ultimo nome deve ter entre 2 a 32 caracteres")
    private String lastName;
    @Size(min = 11, max = 11, message = "O Seu cpf nome deve ter 11 caracteres")
    private String cpf;
    //@Size(min = 5, max = 9, message = "O tipo de ter entre 5 a 9 caracteres")
    private String email;
    @Size(min = 5, max = 9, message = "O tipo de ter entre 5 a 9 caracteres")
    private String role;

    @Valid
    private UserRequestDto userRequestDto;

}
