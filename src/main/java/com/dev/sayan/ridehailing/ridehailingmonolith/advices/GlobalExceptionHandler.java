package com.dev.sayan.ridehailing.ridehailingmonolith.advices;

import com.dev.sayan.ridehailing.ridehailingmonolith.exceptions.ResourceNotFoundException;
import com.dev.sayan.ridehailing.ridehailingmonolith.exceptions.RuntimeConflictException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> HandleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiError error = ApiError.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
        //return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError error) {
        return new ResponseEntity<>(new ApiResponse<>(error), error.getHttpStatus());
    }
    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException  exception) {
        ApiError error = ApiError.builder()
                .httpStatus(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
        //return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleInternalServerErrorException(Exception exception) {
        ApiError error = ApiError.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(error);
        //return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodValidationNotAcceptedError(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        ApiError error = ApiError.builder()
                .message("input validation failed")
                .subErrors(errors)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return buildErrorResponseEntity(error);
        //return new ResponseEntity<>(error,HttpStatu
    }
}
