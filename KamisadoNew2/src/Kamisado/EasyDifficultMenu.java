package Kamisado;

import java.io.File;
import java.net.MalformedURLException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EasyDifficultMenu 
{
	  public void chooseLevel(Stage window) //throws Exception
	    {
		  	window.setTitle("Choose Computer Difficulty");
	        VBox box = new VBox(20);	
	        Label nameLabel = new Label("Choose Level");
	        nameLabel.setId("bold-label");
		  
	        Scene nameScene = new Scene(box, 1000, 600);
	        Button easyBtn = new Button("\t\t    Easy  \t\t\t");
	        Button difficultBtn = new Button("\t\t  Difficult  \t\t");
	        final Button quit = new Button("\t\tQuit Game\t\t");
	    
	        easyBtn.setOnMouseEntered(e -> easyBtn.setStyle("-fx-text-fill:#000000;"));
	        easyBtn.setOnMouseExited(e -> easyBtn.setStyle("-fx-background-color: #AB4642;"));
	        difficultBtn.setOnMouseEntered(e -> difficultBtn.setStyle("-fx-text-fill:#000000;"));
	        difficultBtn.setOnMouseExited(e -> difficultBtn.setStyle("-fx-background-color: #AB4642;"));
	        quit.setOnMouseEntered(e -> quit.setStyle("-fx-text-fill:#000000;"));
	        quit.setOnMouseExited(e -> quit.setStyle("-fx-background-color: #AB4642;"));
	       
	        box.getChildren().addAll(nameLabel, easyBtn, difficultBtn, quit);
	        
	        
	        //Main newGame = new Main();
	        //play.setOnAction(e-> newGame.startScene(window));
	        quit.setOnAction(e -> window.close());
	        

	        try
	        {
	            nameScene.getStylesheets().add((new File("CSSMainMenu.css")).toURI().toURL().toExternalForm());
	        }//end try
	        catch(MalformedURLException ex)
	        {
	            System.out.println("Exception caught");
	        }//end catch

	        box.setAlignment(Pos.CENTER);
	        //set scene colour to same as main menu colour
	        nameScene.setFill(Color.web("#383838",1.0));
	        window.setScene(nameScene);
	        window.show();

	    }//end method
	
	
	

}
