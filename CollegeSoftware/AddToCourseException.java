package src;

/**
 * AddToCourseException
 *
 * Exception thrown for invalid add operations involving the Course class.
 *
 *
 */

public class AddToCourseException extends Exception {
    /**
     * Constructs an AddToCourseException with the default message.
     *
=     */
    public AddToCourseException() {
        System.out.println("Error");
    }

    public AddToCourseException(String message) {
         System.out.println(message);
    }
}
