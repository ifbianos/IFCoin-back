package com.ifba.config.enuns;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErroEnum {
    DUPLICATE_CPF("Cpf já cadastrado no sistema!", HttpStatus.CONFLICT),
    DUPLICATE_USERNAME("Username já cadastrado no sistema!", HttpStatus.BAD_REQUEST),
    ACCOUNT_NOT_FOUND("Conta não encontrada!", HttpStatus.NOT_FOUND),
    USERNAME_INVALID("Username invalido!", HttpStatus.NOT_FOUND),
    USERNAME_PASSWORD_INVALID("Senha Invalida!", HttpStatus.NOT_FOUND),
    STUDENT_IN_NONEXISTENT_EVENT("Você não está em um evento!", HttpStatus.NOT_FOUND),
    GENERIC_ERROR("Ocorreu um erro durante o processo, tente novamente!", HttpStatus.NOT_FOUND),
    WRONG_ROLE("Só poderá cadastrar como professor ou aluno", HttpStatus.BAD_REQUEST),



    SEMIDEIA("nada feito ainda", HttpStatus.LOCKED);

    private final String description;
    private final HttpStatus httpStatus;

    ErroEnum(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
