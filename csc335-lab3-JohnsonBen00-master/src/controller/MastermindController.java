package controller;
import model.MastermindModel;
/**
 * This class interacts with the user's guess and the computed answer.
 * Sends booleans to the view, which prints helpful instructions to the console to help to user
 * guess the right answer
 * @author Benhur J. Tadiparti
 *
 */
public class MastermindController {

	private MastermindModel model;
	
	public MastermindController(MastermindModel model) {
		this.model = model;
	}
	
	/**
	 * Checks to see if the guess if correct
	 * @param guess -- user's guess
	 * @return true -- if the guess is the answer
	 * @throws MastermindIllegalColorException -- returns a color error string
     * @throws MastermindIllegalLengthException -- returns a length error string
	 */
    public boolean isCorrect(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	char[] ans = guess.toCharArray(); //Converts out string "guess" to a char array
    	for (int i = 0; i < guess.length(); i++) {
    		//Checks to see if our guess and the computer generated answer are different
    		if (model.getColorAt(i) != ans[i]) { 
    			return false;                    
    		}
    	}
    	return true; //Else everything is the same and return true
    }
    
    /**
     * Checks to see if the guess at certain indexes are the same
     * @param guess -- user's guess
     * @return correct -- the number of colors in the right place
     * @throws MastermindIllegalColorException -- returns a color error string
     * @throws MastermindIllegalLengthException -- returns a length error string
     */
    public int getRightColorRightPlace(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	throwExceptions(guess);
    	//Counter variable
    	int correct = 0; //Counts the number of colors that are in the right place
    	char[] ans = guess.toCharArray(); //Converts out string "guess" to a char array
    	for (int i = 0; i < guess.length(); i++) {
    		//Checks to see if our guess[i] and the computer generated answer[i] are the same
    		//Increments our counter variable
    		if (model.getColorAt(i) == ans[i]) {
    			correct++;
    		}
    	}
    	return correct;
    }
    
    /**
     * Checks to see if the guess the correct color, but in different places
     * @param guess -- user's guess
     * @return correct -- the numbers of correct color in the computed answer but 
     * 					  are in the wrong place in guess
     * @throws MastermindIllegalColorException -- returns a color error string
     * @throws MastermindIllegalLengthException -- returns a length error string
     */
    public int getRightColorWrongPlace(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	throwExceptions(guess);
    	//Counter variable
    	int correct = 0; //Counts the number of colors that are in the wrong place
    	char[] my_guess = guess.toCharArray(); //Converts out string "guess" to a char array
    	int[] rcrp = new int[] {0, 0, 0, 0}; //Right color right place array
    	
    	//Basically the 'Right color right place' function
    	for (int i = 0; i < my_guess.length; i++) {
    		//Checks to see if our guess[i] and the computer generated answer[i] are the same
    		//Changes our guess[i] to something else so we don't have duplicates
    		//Turns on the appropriate rcrp[i] so we don't have duplicates
    		if (model.getColorAt(i) == my_guess[i]) {
				my_guess[i] = '0';
				rcrp[i] = 1;
				}
    	}
    	
    	//Checks the other colors in guess to see if they are in the wrong place 
    	//compared to the computer generated answer
    	for (int j = 0; j < my_guess.length; j++) { // computer generated answer[j]
    		for (int k = 0; k < my_guess.length; k++) { // our guess[k]
    			//Checks to see if our guess[k] and the computer generated answer[j] are the same
    			//while k != j
    			//Increments our counter variable
        		//Changes our guess[i] to something else so we don't have duplicates
    			if ((model.getColorAt(j) == my_guess[k]) && (rcrp[j] != 1)) {
    				correct++;
    				my_guess[k] = '0';
    				break;
	    			}
    		}
    	}
    	return correct;
    }
    
    /**
     * Checks to see if the user's guess is valid
     * Also this is for the tester
     * @param guess -- user's guess
     * @throws MastermindIllegalColorException -- returns a color error string
     * @throws MastermindIllegalLengthException -- returns a length error string
     */
    public void throwExceptions(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	if (guess.length() != 4) { //Checks to see if guess is length 4
    		throw new MastermindIllegalLengthException();
    	}
    	String choice = "roygbp";
    	for(int i = 0; i < guess.length(); i++) {
    		if (!choice.contains(guess.substring(i, i+1))) { //Checks to see if every Char in guess is a valid color
    			throw new MastermindIllegalColorException();
    		}
    	}
    	
    }
    
}
