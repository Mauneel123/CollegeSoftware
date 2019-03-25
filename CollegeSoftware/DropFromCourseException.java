package src;

/**
 * DropFromCourseException
 *
 * Exception thrown for invalid drop operations involving the Course class.
 */

public class DropFromCourseException extends Exception {
    /**
     * Constructs a DropFromCourseException with the default message.
     */
    public DropFromCourseException() {
        //TODO: Call the superclass's constructor with a default message
        System.out.println("Error");
    }

    /**
     * Constructs a DropFromCourseException with the provided message.
     *
     * @param message Message to be provided to the user in case of exception
     */
    public DropFromCourseException(String message) {
        //TODO: Call the superclass's constructor with a the message
        System.out.println(message);
    }
}
