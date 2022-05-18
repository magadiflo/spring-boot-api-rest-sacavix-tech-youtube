package com.magadiflo.todoapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { ToDoExceptions.class })
    protected ResponseEntity<Object> handlerConflict(ToDoExceptions ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        Map<String, Object> response = new HashMap<>();
        response.put("mensaje", bodyOfResponse);
        return handleExceptionInternal(ex, response, new HttpHeaders(), ex.getHttpStatus(), request);
    }
}
