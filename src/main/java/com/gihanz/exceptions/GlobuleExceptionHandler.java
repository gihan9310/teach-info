package com.gihanz.exceptions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerWebInputException;

import static com.gihanz.configs.TextConstrain.*;

@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class GlobuleExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleException(RecordNotFoundException ex) {
        log.debug(EX_RECORD_NOT_EXIST, ex.getMessage());
        return ResponseEntity.badRequest().body(ExceptionResponse.builder()
                .errorCode(RESPONSE_CODE.NOT_FOUND.getCode())
                .description(EX_RECORD_NOT_FOUND)
                .message(EX_RECORD_NOT_FOUND)
                .build());
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponse> handleException(CustomException ex) {
        log.debug(EX_BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(ExceptionResponse.builder()
                .errorCode(RESPONSE_CODE.BAD_REQUEST.getCode())
                .description(EX_BAD_REQUEST)
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleException(UnauthorizedException ex) {
        log.debug(EX_UNAUTHORIZED, ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ExceptionResponse.builder()
                .errorCode(RESPONSE_CODE.UNAUTHORIZED.getCode())
                .description(EX_UNAUTHORIZED)
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        ex.printStackTrace();
        log.debug(EX_BAD_REQUEST, ex.getMessage());
        return ResponseEntity.badRequest().body(ExceptionResponse.builder()
                .errorCode(RESPONSE_CODE.BAD_REQUEST.getCode())
                .description(ex.getLocalizedMessage())
                .message(ex.getMessage())
                .build());
    }

    @ExceptionHandler(ServerWebInputException.class)
    public ResponseEntity<String> handleInvalidInput(ServerWebInputException ex) {
        ex.printStackTrace();
        return ResponseEntity.badRequest().body("Invalid input: " + ex.getMessage());
    }

}
