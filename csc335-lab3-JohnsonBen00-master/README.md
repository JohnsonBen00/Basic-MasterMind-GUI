# csc335 Basic Mastermind GUI

## Setup

Once again, we will be using your Mastermind code from projects 1 and 2. This time, we will be making a simple, textual GUI for our mastermind project.

1. With this repository cloned locally, create a new Eclipse Java Project into the repository folder. Import your `MastermindController`, `MastermindModel`, and exception classes into the project.

2. Create a new Java File named `MastermindTextGUI` that extends `javafx.application.Application`, with Eclipse generating a main method for you and the override of start.

3. In  `MastermindTextGUI`, give the Stage parameter a better name, and you can remove the `throws Exception` from the signature.

4. In `main`, call `launch` on the commandline arguments.

## Your GUI

We will be implementing the simple GUI shown in the picture below (best viewed on github.com or open screenshot.png from the repository to see):

![GUI Screenshot](screenshot.png?raw=true "Screenshot")

1. Create a `BorderPane` to hold our two text controls
2. The upper control is a `TextArea`, which allows multiple lines to be displayed. Rather than printing to System.out, we will be calling `appendText` to add new lines to this box with our output formatted as shown.
3. We don't want the user to edit the `TextArea`, so we will `setEditable(false)` on it
4. We know we will have the welcome message, up to 10 guesses, and the win/loss message, so we can make sure that the `TextArea` can show 12 lines via `setPrefRowCount(12)`. 
5. We can add the `TextArea` to the center of our `BorderPane`
6. The bottom control is a `TextField`
7. Use `setPromptText` to have a prompt text of "Type your guess (Enter to submit)"
8. When the user types a guess and hits enter, we want some code to run, so using either an inner class or a lambda, create an action handler and assign it to the `TextField` using `setOnAction`
9. In that handler, score the guess, determine win or loss, or handle an exception
10. With an exception, use this code to display a dialog box:

```Java
new Alert(Alert.AlertType.ERROR, "This is an error!").showAndWait();
```

11. With each guess, clear the `TextField`
12. When the game is won or lost, `setEditable(false)` on the `TextField`

## Eclipse/JDK 8/JavaFX Issue

If you run into a problem where Eclipse says you cannot use JavaFX, perform the following steps:

1. Right click on the project
2. Go to Properties
3. Select Java Build Path
4. Go to the Libraries tab
5. Expand Modulepath and JRE System Library
6. Select Access rules and click the Edit... button
7. Click the Add... button
8. Select Accessible from the Resolution dropdown 
9. Enter `javafx/**` for the rule pattern

And things should work. JDK 10 doesn't seem to have the issue.
