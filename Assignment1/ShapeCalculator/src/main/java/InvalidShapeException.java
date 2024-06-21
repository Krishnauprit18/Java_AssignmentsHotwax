package main.java;

/**
 * Exception thrown when an invalid shape is selected.
 */
class InvalidShapeException extends Exception{
    InvalidShapeException(String message){
        super(message);
    }
}