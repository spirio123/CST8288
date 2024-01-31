/**
 * File name: ValidationException.java
 * Student Name: Ollie Savill
 * Student Number: 041079682
 * Course & Section #: 22S_CST8288_011
 * Date: February, 2023
 * Declaration:
 * This is my own original work and is free from Plagiarism.
 */
package businesslayer;

/**
 *
 * This class represents an exception that is thrown when data being validated
 * does not meet the required format or criteria. The ValidationException class
 * extends the Exception class.
 *
 * @author savil
 */
public class ValidationException extends Exception {

    /**
     * Constructs a ValidationException object with a default message.
     */
    public ValidationException() {
        super("Data not in valid format");
    }

    /**
     * Constructs a ValidationException object with the specified message.
     *
     * @param message the message to be associated with the exception
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Constructs a ValidationException object with the specified message and
     * cause.
     *
     * @param message the message to be associated with the exception
     * @param throwable the cause of the exception
     */
    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a ValidationException object with the specified cause.
     *
     * @param throwable the cause of the exception
     */
    public ValidationException(Throwable throwable) {
        super(throwable);
    }
}
