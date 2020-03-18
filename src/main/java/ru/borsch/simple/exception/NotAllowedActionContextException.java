package ru.borsch.simple.exception;

public class NotAllowedActionContextException extends RuntimeException {

    public NotAllowedActionContextException() {
    }

    public NotAllowedActionContextException(String message) {
        super(message);
    }

    public NotAllowedActionContextException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAllowedActionContextException(Throwable cause) {
        super(cause);
    }
}
