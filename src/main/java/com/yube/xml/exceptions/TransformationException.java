package com.yube.xml.exceptions;

public class TransformationException extends RuntimeException {

    private static final long serialVersionUID = -7485832606391376774L;

    public TransformationException() {
    }

    public TransformationException(Throwable cause) {
        super(cause);
    }

    public TransformationException(String message) {
        super(message);
    }

    public TransformationException(String message, Throwable cause) {
        super(message, cause);
    }
}

