package model;
import java.lang.String;
/**
 * This class generates a random answer with 'choices' given, and length 4.
 * Has methods that interacts with the computed answer.
 * @author Benhur J. Tadiparti
 *
 */
public class MastermindModel {
	
	private char[] choices = new char[]{ 'r', 'o', 'y', 'g', 'b', 'p'}; //The six color to choice from
	private char[] answers = new char[4]; //The computer generated answer
	
	
	/**
	 * Gets 4 random colors
	 */
    public MastermindModel() { 
    	int max = 6;
    	int min = 0;
    	int num = 0;
    	for (int i = 0; i < answers.length; i++) {
    		num = (int) (Math.random() * ( max - min ));
    		answers[i] = choices[num];
    	}
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	char[] ans = answer.toCharArray();
    	for (int i = 0; i < answers.length; i++) {
    		answers[i] = ans[i];
    	}
    }
    
    /**
     * Returns the color at that index
     * @param index -- index of the char in answer we want
     * @return the char in answer we want
     */
    public char getColorAt(int index) {
    	return answers[index];
    }

}
