package com.ifba.application.exception.details;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.List;


@Slf4j
@Getter
public class MessageErro {

    private String erro;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorObject> errorObjectList;
    private Integer status;
    private String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    @JsonIgnore
    private HttpStatus httpStatus;

    public MessageErro erro(String erro) {
        this.erro = erro;
        return this;
    }

    public MessageErro erroList(List<ErrorObject> errorObjectList) {
        this.errorObjectList = errorObjectList;
        return this;
    }


    public MessageErro status(Integer status) {
        this.status = status;
        return this;
    }

    public MessageErro timeStamp() {
        this.timeStamp = getTimeStamp();
        return this;
    }


    public HttpStatus httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return httpStatus;
    }
}
