package ua.realestate.management.exception.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ua.realestate.management.exception.exceptions.UserAlreadyRegisteredException;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorAttributes errorAttributes;

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> handleRuntimeException(ExceptionResponse exception){
     ExceptionResponse exceptionResponse = new ExceptionResponse(
             exception.getMessage());
     log.trace(exception.getMessage(), exception);
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public final ResponseEntity<Object> userAlreadyRegisteredException(ExceptionResponse exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

}
