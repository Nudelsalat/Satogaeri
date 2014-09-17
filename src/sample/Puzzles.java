package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Cloud on 17.09.2014.
 */
public class Puzzles extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception{
        Button easy = new Button("easy");
        Button medium = new Button("medium");
        Button hard = new Button("hard");

        Button easy_back = new Button("back");
        Button sakamoto = new Button("Sakamoto");
        Button aquablue = new Button("aquablue");

        GridPane easy_grid = new GridPane();
        easy_grid.setAlignment(Pos.CENTER);
        easy_grid.setHgap(10);
        easy_grid.setVgap(10);
        easy_grid.setPadding(new Insets(25, 25, 25, 25));
        easy_grid.add(sakamoto, 0, 0);
        easy_grid.add(aquablue, 0, 1);
        easy_grid.add(easy_back, 1,3);
        final Scene easy_scene = new Scene(easy_grid, 300, 275);

        sakamoto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet.");
            }
        });

        aquablue.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet.");
            }
        });



        Button z_h = new Button("Z_H");
        Button alkaline = new Button("alkaline");
        Button casty = new Button("Casty");
        Button cubic_function = new Button("cubic function");
        Button medium_back = new Button("back");

        GridPane medium_grid = new GridPane();
        medium_grid.setAlignment(Pos.CENTER);
        medium_grid.setHgap(10);
        medium_grid.setVgap(10);
        medium_grid.setPadding(new Insets(25, 25, 25, 25));
        medium_grid.add(z_h, 0, 0);
        medium_grid.add(alkaline, 0, 1);
        medium_grid.add(casty, 0, 2);
        medium_grid.add(cubic_function, 0, 3);
        medium_grid.add(medium_back, 1,5);
        final Scene medium_scene = new Scene(medium_grid, 300, 275);

        alkaline.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet.");
            }
        });

        casty.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet.");
            }
        });

        cubic_function.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet.");
            }
        });

        z_h.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet."+this.toString());
            }
        });


        Button t_karino = new Button("T.Karino");
        Button minus_4 = new Button("-4");
        Button aiko = new Button("aiko");
        Button bay_wolf_jr = new Button("bay wolf Jr");
        Button hard_back = new Button("back");

        final GridPane hard_grid = new GridPane();
        hard_grid.setAlignment(Pos.CENTER);
        hard_grid.setHgap(10);
        hard_grid.setVgap(10);
        hard_grid.setPadding(new Insets(25, 25, 25, 25));
        hard_grid.add(t_karino, 0, 0);
        hard_grid.add(minus_4, 0, 1);
        hard_grid.add(aiko, 0, 2);
        hard_grid.add(bay_wolf_jr, 0, 3);
        hard_grid.add(hard_back, 1,5);
        final Scene hard_scene = new Scene(hard_grid, 300, 275);


        t_karino.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet."+this.toString());
            }
        });
        minus_4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet."+this.toString());
            }
        });
        aiko.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet."+this.toString());
            }
        });
        bay_wolf_jr.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("not done yet."+this.toString());
            }
        });


        easy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("screen shows easy-puzzles");
                primaryStage.setScene(easy_scene);
            }
        });

        medium.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(medium_scene);
            }
        });

        hard.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solver not done yet.");
                primaryStage.setScene(hard_scene);
            }
        });


        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(easy, 0, 0);
        root.add(medium, 0, 1);
        root.add(hard, 0, 2);
        final Scene root_scene = new Scene(root, 300, 275);

        easy_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solver not done yet.");
                primaryStage.setScene(root_scene);
            }
        });
        medium_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solver not done yet.");
                primaryStage.setScene(root_scene);
            }
        });
        hard_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solver not done yet.");
                primaryStage.setScene(root_scene);
            }
        });

        primaryStage.setTitle("Satogaeri");
        primaryStage.setScene(root_scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
