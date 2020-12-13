package io.dsub.shoppingdemo.exception;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// AOP Pointcut Handling!
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<?> handleError(BaseException e) {
        return ResponseEntity.status(e.getStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getMessage());
    }
}
