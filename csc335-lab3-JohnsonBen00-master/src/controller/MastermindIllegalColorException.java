package controller;
/**
 * This class prints out a color error
 * @author Benhur Tadiparti
 *
 */
public class MastermindIllegalColorException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Prints out a line
	 */
	public MastermindIllegalColorException() 
    { 
        toString();
    }
	
	/**
	 * Returns a string
	 */
	public String toString() {
		return "Invalid color(s) in user's guess";
	}
}

