package ua.realestate.management.exception.exceptions;

public class BadEmailException extends RuntimeException{
    public BadEmailException(String message){
        super(message);
    }
}
