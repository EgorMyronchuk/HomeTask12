package org.example.Humans;

public class FamilyOverflowException extends RuntimeException{
    public FamilyOverflowException() {
        super("Family size exceeds the maximum allowed capacity");
    }

    public FamilyOverflowException(String message) {
        super(message);
    }

    public FamilyOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilyOverflowException(Throwable cause) {
        super(cause);
    }
}
