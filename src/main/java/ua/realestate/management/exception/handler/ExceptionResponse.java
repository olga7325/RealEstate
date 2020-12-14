package ua.realestate.management.exception.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ExceptionResponse {
    private String message;


    public ExceptionResponse(String message){
        this.message = message;
    }
}
