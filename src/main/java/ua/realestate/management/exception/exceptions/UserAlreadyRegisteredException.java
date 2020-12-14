package ua.realestate.management.exception.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException{

    public UserAlreadyRegisteredException (String message){
        super(message);
    }
}
