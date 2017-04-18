package Kamisado;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;

public class MainMenu extends Application
{

    private Stage  window;

    public static void main(String[] args)
    {
        launch(args);
    }//end main

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Kamisado Menu");

        VBox box = new VBox(20);

        Label nameLabel = new Label("Kamisado");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 1, 0);


        final PlayerNames name = new PlayerNames();
        final EasyDifficultMenu level = new EasyDifficultMenu();
        final Button play2Game = new Button("2 Player Game");
        final Button play1Game = new Button("1 Player Game");
        final Button quit = new Button("   Quit Game   ");

        box.setAlignment(Pos.CENTER);

		play2Game.setOnAction(e-> name.enterNames(window));
		play1Game.setOnAction(e -> level.chooseLevel(window));
        quit.setOnAction(e-> window.close());


        //Add to VBox
        box.getChildren().addAll(nameLabel, play2Game, play1Game, quit);
        Scene scene = new Scene(box, 1000, 600);
        scene.getStylesheets().add((new File("CSSMainMenu.css")).toURI().toURL().toExternalForm());

        play1Game.setOnMouseEntered(e -> play1Game.setStyle("-fx-text-fill:#000000;"));
        play2Game.setOnMouseEntered(e -> play2Game.setStyle("-fx-text-fill:#000000;"));
        quit.setOnMouseEntered(e -> quit.setStyle("-fx-text-fill:#000000;"));
        play1Game.setOnMouseExited(e -> play1Game.setStyle("-fx-background-color: #AB4642;"));
        play2Game.setOnMouseExited(e -> play2Game.setStyle("-fx-background-color:#AB4642;"));
        quit.setOnMouseExited(e -> quit.setStyle("-fx-background-color:#AB4642;"));

        window.setScene(scene);
        window.show();

    }//end start

}//end class
