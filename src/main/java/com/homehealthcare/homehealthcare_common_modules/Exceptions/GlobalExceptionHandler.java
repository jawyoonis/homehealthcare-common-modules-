package com.homehealthcare.homehealthcare_common_modules.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        log.error("Resource not found exception: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, "RESOURCE_NOT_FOUND", request);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException(
            ValidationException ex, WebRequest request) {
        log.error("Validation exception: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "VALIDATION_ERROR", request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(
            EntityNotFoundException ex, WebRequest request) {
        log.error("Entity not found exception: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.NOT_FOUND, "ENTITY_NOT_FOUND", request);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        log.error("Illegal argument exception: {}", ex.getMessage());
        return buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "INVALID_ARGUMENT", request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Method argument validation failed: {}", ex.getMessage());

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.put("type", "VALIDATION_ERROR");
        body.put("exception", ex.getClass().getSimpleName());
        body.put("path", request.getDescription(false));

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("details", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllUncaughtException(
            Exception ex, WebRequest request) {
        log.error("Uncaught exception: ", ex);
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR", request);
    }

    private ResponseEntity<Object> buildErrorResponse(
            Exception ex,
            HttpStatus status,
            String type,
            WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("type", type);
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false));
        body.put("exception", ex.getClass().getSimpleName());

        // Add cause for internal errors
        if (status == HttpStatus.INTERNAL_SERVER_ERROR && ex.getCause() != null) {
            body.put("cause", ex.getCause().getMessage());

            // Add stack trace in non-production environments
            if (!isProduction()) {
                body.put("stackTrace", getStackTrace(ex));
            }
        }

        return new ResponseEntity<>(body, status);
    }

    private boolean isProduction() {
        String profile = System.getProperty("spring.profiles.active");
        return profile != null && profile.contains("prod");
    }

    private List<String> getStackTrace(Exception ex) {
        return List.of(ex.getStackTrace())
                .stream()
                .map(StackTraceElement::toString)
                .limit(10) // Limit stack trace to first 10 lines
                .collect(Collectors.toList());
    }
}