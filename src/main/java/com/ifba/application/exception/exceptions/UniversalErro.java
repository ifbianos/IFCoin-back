package com.ifba.application.exception.exceptions;

import com.ifba.config.enuns.ErroEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UniversalErro extends RuntimeException{


    private HttpStatus httpStatus;

    public UniversalErro(ErroEnum erroEnum) {
        super(erroEnum.getDescription());
        this.httpStatus = erroEnum.getHttpStatus();
    }
}
