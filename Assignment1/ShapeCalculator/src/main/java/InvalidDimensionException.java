package main.java;

/**
 * Exception thrown when a dimension of a shape is invalid.
 */
class InvalidDimensionException extends Exception{
    InvalidDimensionException(String message){
        super(message);
    }
}