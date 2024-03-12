package ru.lab.authorization.service.service.exception;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException(String msg) {
        super(msg);
    }
    public InvalidUsernameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}