package com.ifba.domain.dto.requestaccount;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class RequestAccountDtoOut {

    private Long Id;
    private String name;
    private String lastName;
    private String cpf;
    private String role;


}
