package com.ifba.domain.dto.requestaccount;

import com.ifba.domain.entity.User;
import com.ifba.domain.entity.UserRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class RequestAccountDtoIn {

    private String name;
    private String lastName;
    private String cpf;
    private String role;

    private UserRequest userRequest;

}
