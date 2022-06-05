package com.ifba.application.exception.handler;

import com.ifba.application.exception.details.ErrorObject;
import com.ifba.application.exception.details.MessageErro;
import com.ifba.application.exception.exceptions.UniversalErro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UniversalErro.class)
    public ResponseEntity<MessageErro> internalErro(UniversalErro universalErro){
        return new ResponseEntity<>(
                new MessageErro()
                        .erro(universalErro.getMessage())
                        .status(universalErro.getHttpStatus().value())
                        .timeStamp()
                , new MessageErro().httpStatus(universalErro.getHttpStatus()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        return new ResponseEntity<>(
                new MessageErro()
                        .erro("Erro de preenchimento")
                        .erroList(errors)
                        .status(status.value())
                        .timeStamp()
                , new MessageErro().httpStatus(status));
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
    }

}
