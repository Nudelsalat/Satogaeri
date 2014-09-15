package sample;

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
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception{
        Button new_game = new Button();
        final Button generate = new Button();
        Button solve = new Button();
        new_game.setText("Start new Game");
        new_game.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("game in progress...");
            }
        });

        generate.setText("Puzzle Generator");
        generate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Generator generator = new Generator();
                try {
                    generator.start(primaryStage);
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

        solve.setText("Solver");
        solve.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solver not done yet.");
            }
        });

        GridPane root = new GridPane();
        //root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(new_game, 0, 0);
        root.add(generate, 0, 1);
        root.add(solve, 0, 2);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
