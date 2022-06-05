package com.ifba.application.exception.details;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorObject {

    private String message;
    private String field;
}
