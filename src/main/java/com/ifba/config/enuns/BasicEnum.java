package com.ifba.config.enuns;

import lombok.Getter;

@Getter
public enum BasicEnum {
    TEACHER("professor"),
    STUDENT("aluno"),
    STORE("cantina"),
    COORDINATOR_MAIL("coordenador");

    private final String description;


    BasicEnum(String description) {
        this.description = description;
    }
}
