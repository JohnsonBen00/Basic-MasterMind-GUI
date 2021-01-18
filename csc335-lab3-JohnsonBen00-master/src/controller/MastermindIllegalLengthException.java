package controller;
/**
 * This class prints out a length error
 * @author Benhur Tadiparti
 *
 */
public class MastermindIllegalLengthException extends Exception {	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Prints out a line
	 */
	public MastermindIllegalLengthException() 
    { 
        toString();
    }
	
	/**
	 * Returns a string
	 */
	public String toString() {
		return "Invalid length in user's guess";
	}
}