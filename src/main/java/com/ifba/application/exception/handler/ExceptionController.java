package com.ifba.application.exception.handler;

import com.ifba.application.exception.details.MessageErro;
import com.ifba.application.exception.exceptions.UniversalErro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(UniversalErro.class)
    public ResponseEntity<MessageErro> internalErro(UniversalErro universalErro){
        return new ResponseEntity<>(
                new MessageErro()
                        .erro(universalErro.getMessage())
                        .status(universalErro.getHttpStatus().value())
                        .timeStamp()
                , new MessageErro().httpStatus(universalErro.getHttpStatus()));
    }

}
