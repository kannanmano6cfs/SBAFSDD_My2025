package com.learning.exproductservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(ProductNotFoundException e, WebRequest request) {
        Map<String,Object> map = new HashMap<>();
        map.put("message",e.getMessage());
        map.put("status", "Httpstatus not found");
        map.put("timestamp", LocalDateTime.now().toString());
        map.put("path", request.getDescription(false).replace("uri=",""));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
