package com.github.leandroalcantara_1997.api_sistema_login.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HandlerException {
    
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<JsonFormatException> dataBaseException(DataBaseException e, HttpServletRequest r){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        JsonFormatException error = new JsonFormatException(Instant.now(), status, "Erro ao retornar cadastro", e.getMessage(), r.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UtilException.class)
    public ResponseEntity<JsonFormatException> utilException(UtilException e, HttpServletRequest r){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        JsonFormatException error = new JsonFormatException(Instant.now(), status, "Ocorreu um erro", e.getMessage(), r.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
