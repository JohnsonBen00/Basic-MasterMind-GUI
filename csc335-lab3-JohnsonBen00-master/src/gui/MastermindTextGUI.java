package gui;

import controller.MastermindController;
import controller.MastermindIllegalColorException;
import controller.MastermindIllegalLengthException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MastermindModel;
/**
 * This class simulates a GUI Mastermind game.
 * The user can make 10 valid guesses till they lose the game.
 * If not a valid guess, the class asks the user again for a valid guess.
 * @author Benhur J. Tadiparti
 *
 */
public class MastermindTextGUI extends javafx.application.Application {
	
	
	private MastermindModel model = new MastermindModel(); //Model object
	private MastermindController controller = new MastermindController(model); //Controller object
	
	/**
	 * Runs the GUI program
	 * @param args -- the Gui
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Generates the GUI game. Given the Gui stage, the function creates the window and scene with
	 * the appropriate info displayed on them, with the help of a event handler. The event handler
	 * listens and is triggered only when the input is submitted into  the textField. The handler 
	 * scores the guess, determines win, or handles an exception till 10 guesses have been submitted.
	 * Then a loss is confirmed. 
	 * @param stage -- the GUI stage
	 */
	@Override
	public void start(Stage stage) {
		stage.setTitle("Mastermind"); //Title
		BorderPane window = new BorderPane();
		Scene scene = new Scene(window, 500, 300); //Stage size
		
		TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefRowCount(12);
        
        TextField textField = new TextField();
        textField.setPromptText("Type your guess (Enter to submit)");
        
        textArea.appendText("Welcome to Mastermind");
        
        textField.setOnAction(new EventHandler<ActionEvent>() {
        	int game = 1;
        	public void handle(ActionEvent event) {
        		if (game < 10) {
        			textArea.appendText("\nGuess " + game + ": ");
        			textArea.appendText(textField.getText()); //User guess
        			try {
        				if (!controller.isCorrect(textField.getText().toLowerCase())) { //If not correct
        					//Right color right place
        					textArea.appendText("\tRCRP: " + controller.getRightColorRightPlace(textField.getText().toLowerCase()));
        					
        					//Right color wrong place
        					textArea.appendText("\tRCWP: " + controller.getRightColorWrongPlace(textField.getText().toLowerCase()));
        				} else {
        					textArea.appendText("\nYou win!");
        					textField.setEditable(false); //End game
        				}
        			} catch (MastermindIllegalColorException e) {
        				new Alert(Alert.AlertType.ERROR, "This is an error!\n" + e).showAndWait();
        			} catch (MastermindIllegalLengthException e) {
        				new Alert(Alert.AlertType.ERROR, "This is an error!\n" + e).showAndWait();
        			}
        			game++;
            		textField.clear();
        		} else {
        			textArea.appendText("\nYou lose!");
        			textField.setEditable(false); //End game
        		}
        	}
        });
        window.setCenter(textArea);
        window.setBottom(textField);
		stage.setScene(scene);
		
		stage.show();
	}

}
