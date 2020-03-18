package ru.borsch.simple.exception;

public class NotAllowedActionException extends RuntimeException {

    public NotAllowedActionException() {
    }

    public NotAllowedActionException(String message) {
        super(message);
    }

    public NotAllowedActionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedActionException(Throwable cause) {
        super(cause);
    }
}
