package Kamisado;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Feedback
{

	public static void gameWon()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText("Winner!");
        alert.setTitle("Game over");
        alert.setContentText("Player " + Main.c + " has won!");
        alert.showAndWait();

    }//end method

	public static void wrongPlayer()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText("Wrong player");
        alert.setTitle("Not " + Main.c + "'s turn!");
        alert.setContentText("It's not your turn!");
        alert.show();

    }//end method


	public static void wrongColourPiece()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText("Wrong colour");
        alert.setTitle("Picked wrong color tower");
        alert.setContentText("You can only move the color tower that " + Main.c + " has moved on!");
        alert.show();

    }//end method

	public static void illegalMove()
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText("Illegal Move");
        alert.setTitle("You have entered an illegal move!");
        alert.setContentText("Please try a legal move");
        alert.show();

    }//end method
	
	public static void quitGame()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
        //alert.setHeaderText("QUIT Instructions");
        alert.setTitle("How To Quit Game");
        alert.setContentText("To QUIT GAME  press 'ESC' or 'Q' ");
        alert.showAndWait();
	}//end method
	
}
