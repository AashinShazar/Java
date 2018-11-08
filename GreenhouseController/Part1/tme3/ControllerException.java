package tme3;

/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
 *
 * This class Extends the Exception class so we can have our own definition.
 */

public class ControllerException extends Exception { //Step 3,1
    public ControllerException(String message){
        super(message);
    }
}
