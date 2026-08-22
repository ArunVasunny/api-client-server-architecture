package com.userservice.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.userservice.models.APIError;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<APIError> handleRuntimeException(RuntimeException ex, HttpServletRequest servlet)
    {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String path = servlet.getRequestURI();
        APIError apiError = new APIError(
                LocalDateTime.now(), 
                status.value(), 
                status.name(), 
                ex.getMessage(), 
                path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
