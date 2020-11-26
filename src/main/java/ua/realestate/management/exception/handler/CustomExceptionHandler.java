package ua.realestate.management.exception.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ua.realestate.management.exception.exceptions.UserAlreadyRegisteredException;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestControllerAdvice
public class CustomExceptionHandler {

    private ErrorAttributes errorAttributes;

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Object> handleRuntimeException(RuntimeException exception, WebRequest request){
     ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
     log.trace(exception.getMessage(), exception);
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public final ResponseEntity<Object> userAlreadyRegisteredException(WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }


    private Map<String, Object> getErrorAttributes(WebRequest request){
     return new HashMap<>(errorAttributes.getErrorAttributes(request, true));
    }
}
