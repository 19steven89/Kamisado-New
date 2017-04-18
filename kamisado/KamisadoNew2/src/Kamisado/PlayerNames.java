package Kamisado;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;


public class PlayerNames
{

    public void enterNames(Stage window)
    {
        Scene nameScene = new Scene(new Group(), 1000, 600);

        //declare text fields, set the text to be clear upon initialisation
        TextField player1Name = new TextField();
        TextField player2Name = new TextField();
        Button play = new Button("             Play Game              ");
        play.setOnMouseEntered(e -> play.setStyle("-fx-text-fill:#000000;"));
        play.setOnMouseExited(e -> play.setStyle("-fx-background-color: #AB4642;"));   
        
        player1Name.setPromptText("Enter Name");
        player2Name.setPromptText("Enter Name");
        
        Main newGame = new Main();
       	play.setOnAction(e-> newGame.startScene(window, player1Name.getText(), player2Name.getText()));

        //set values of 1st text field
        GridPane grid = new GridPane();
        grid.setVgap(13);
        grid.setHgap(10);

        grid.setPadding(new Insets(150, 350, 350, 50));
        grid.add(new Label("Player 1 Name: "), 0, 0);
        grid.add(player1Name, 1, 0);

        grid.add(new Label("Player 2 Name: "), 0, 1);
        grid.add(player2Name, 1, 1);

        grid.add(play, 1, 2);
        grid.setAlignment(Pos.CENTER);

        Group root = (Group) nameScene.getRoot();
        root.getChildren().add(grid);

        try
        {
            nameScene.getStylesheets().add((new File("CSSMainMenu.css")).toURI().toURL().toExternalForm());
        }//end try
        catch(MalformedURLException ex)
        {
            System.out.println("Exception caught");
        }//end catch

        //set scene colour to same as main menu colour
        nameScene.setFill(Color.web("#383838",1.0));
        window.setScene(nameScene);
        window.show();

    }//end method

}//end class
