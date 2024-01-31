/**
 * File name: ValidationException.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: April, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package businesslayer;

/**
 * The ValidationException class extends the Exception class to provide a custom
 * exception for handling validation errors. It is used to signal when data is
 * not in a valid format.
 */
public class ValidationException extends Exception {

    /**
     * Constructs a new ValidationException with a default error message.
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a new ValidationException with a specified error message.
     *
     * @param message A String representing the error message.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a new ValidationException with a specified error message and a
     * Throwable cause.
     *
     * @param message A String representing the error message.
     * @param throwable A Throwable object representing the cause of the
     * exception.
     */
    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new ValidationException with a Throwable cause.
     *
     * @param throwable A Throwable object representing the cause of the
     * exception.
     */
    public ValidationException(Throwable throwable) {
        super(throwable);
    }
}
