package ru.lab.authorization.service.service.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
    public UserAlreadyExistsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}