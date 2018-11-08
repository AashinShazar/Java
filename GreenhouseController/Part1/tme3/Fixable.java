package tme3;

/**
 * TME-3
 * Name: Aashin Shazar
 * Student ID: 3348955
 * Date written: 12/3/2017
 *
 * The Fixable interface that performs a fix and logs errors to a fix.log file. 
 */

public interface Fixable { // Step 4,1

	// turns Power on, fix window and zeros out error codes
    void fix(); 
	
	// logs to a text file in the current directory called fix.log
	// prints to the console, and identify time and nature of
	// the fix
    void log(); 
}
