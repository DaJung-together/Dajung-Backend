package com.dajung.advice;

import static org.springframework.http.HttpStatus.*;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.dajung.common.exception.ExistsException;
import com.dajung.common.exception.GlobalErrorCode;
import com.dajung.common.exception.NotCryptoException;
import com.dajung.common.exception.NotFoundException;
import com.dajung.response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(Exception e) {
        log.warn("예상치 못한 서버 예외가 발생하였습니다.", e);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(GlobalErrorCode.INTERNAL_SERVER_EXCEPTION));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(NotFoundException exception) {
        log.warn(exception.getLoggingMessage(), exception);
        return ResponseEntity.status(NOT_FOUND)
                .body(ErrorResponse.of(exception.getErrorCode()));
    }

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(ExistsException exception) {
		log.warn(exception.getLoggingMessage(), exception);
		return ResponseEntity.status(CONFLICT)
			.body(ErrorResponse.of(exception.getErrorCode()));
	}

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlerException(NotCryptoException exception) {
		log.warn(exception.getLoggingMessage(), exception);
		return ResponseEntity.status(BAD_REQUEST)
			.body(ErrorResponse.of(exception.getErrorCode()));
	}

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(MethodArgumentTypeMismatchException exception) {
        log.warn(exception.getMessage(), exception);
        return ResponseEntity.badRequest()
                .body(ErrorResponse.of(exception));
    }

}
