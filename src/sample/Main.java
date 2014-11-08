package sample;

import Solver.Puzzle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.peer.FontPeer;

public class Main extends Application {

    //Todo: proper drag&Drop stuff http://docs.oracle.com/javafx/2/drag_drop/jfxpub-drag_drop.htm

    @Override
    public void start(final Stage primaryStage) throws Exception{
        Button new_game = new Button();
        Button generate = new Button();
        Button solve = new Button();
        Button loadbtn = new Button();
        new_game.setText("Start new Game");
        new_game.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Puzzles puzzles = new Puzzles(primaryStage);
                puzzles.show(primaryStage);
                System.out.println("game in progress...");
            }
        });

        generate.setText("Puzzle Generator");
        generate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Generator generator = new Generator(primaryStage);
                generator.show(primaryStage);
                }
        });

        solve.setText("Drawing");
        solve.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Drawing not done yet.");
            }
        });

        loadbtn.setText("Load a puzzle");
        loadbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("loading not done yet.");
            }
        });

        GridPane root = new GridPane();
        Text title = new Text(1.5,2.5,"Satogaeri");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFill(Color.BLUEVIOLET);
        title.setFont(Font.font(26));
        //root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(title,0,0);
        root.add(new_game, 0, 1);
        root.add(generate, 0, 2);
        root.add(solve, 0, 3);
        root.add(loadbtn,0,4);

        primaryStage.setTitle("Satogaeri");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
