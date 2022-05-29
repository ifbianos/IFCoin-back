package com.ifba.config.enuns;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErroEnum {
    DUPLICATE_CPF("Cpf já cadastrado no sistema!", HttpStatus.CONFLICT),
    ACCOUNT_NOT_FOUND("Conta não encontrada!", HttpStatus.NOT_FOUND),
    WRONG_ROLE("Só poderá cadastrar como professor ou aluno", HttpStatus.BAD_REQUEST),

    SEMIDEIA("nada feito ainda", HttpStatus.LOCKED);

    private final String description;
    private final HttpStatus httpStatus;

    ErroEnum(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
