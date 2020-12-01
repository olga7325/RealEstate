package ua.realestate.management.exception.handler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ExceptionResponse {
    private String message;
    @JsonIgnore
    private String timeStamp;
    @JsonIgnore
    private String trace;
    @JsonIgnore
    private String path;

    public ExceptionResponse(String message, String timeStamp, String trace, String path){
        this.message = message;
        this.timeStamp = timeStamp;
        this.trace = trace;
        this.path = path;
    }
}
