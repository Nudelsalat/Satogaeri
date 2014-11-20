package sample;

import Solver.OwnList;
import Solver.Pair;
import Solver.Puzzle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Created by Cloud on 17.09.2014.
 */
public class Puzzles {

    Scene scene;
    Stage primarystage;

    public Puzzles(final Stage primarystage){

        this.primarystage = primarystage;
        Button easy = new Button("easy");
        Button medium = new Button("medium");
        Button hard = new Button("hard");

        Button easy_back = new Button("back");
        Button sakamoto = new Button("Sakamoto");
        Button aquablue = new Button("aquablue");

        GridPane easy_grid = new GridPane();
        easy_grid.setAlignment(Pos.CENTER_LEFT);
        easy_grid.setHgap(10);
        easy_grid.setVgap(10);
        easy_grid.setPadding(new Insets(25, 25, 25, 25));
        easy_grid.add(sakamoto, 0, 0);
        easy_grid.add(aquablue, 0, 1);
        easy_grid.add(easy_back, 1, 3);
        final Scene easy_scene = new Scene(easy_grid, 300, 275);

        sakamoto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\sakamoto"));
                gameVC.show(primarystage);
            }
        });

        aquablue.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\aquablue"));
                gameVC.show(primarystage);
            }
        });


        Button z_h = new Button("Z_H");
        Button alkaline = new Button("alkaline");
        Button casty = new Button("Casty");
        Button cubic_function = new Button("cubic function");
        Button medium_back = new Button("back");

        GridPane medium_grid = new GridPane();
        medium_grid.setAlignment(Pos.CENTER_LEFT);
        medium_grid.setHgap(10);
        medium_grid.setVgap(10);
        medium_grid.setPadding(new Insets(25, 25, 25, 25));
        medium_grid.add(z_h, 0, 0);
        medium_grid.add(alkaline, 0, 1);
        medium_grid.add(casty, 0, 2);
        medium_grid.add(cubic_function, 0, 3);
        medium_grid.add(medium_back, 1, 5);
        final Scene medium_scene = new Scene(medium_grid, 300, 275);

        alkaline.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\alkaline"));
                gameVC.show(primarystage);
            }
        });

        casty.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\casty"));
                gameVC.show(primarystage);
            }
        });

        cubic_function.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\cubic_function"));
                gameVC.show(primarystage);
            }
        });

        z_h.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\z_h"));
                gameVC.show(primarystage);
            }
        });


        Button t_karino = new Button("T.Karino");
        Button minus_4 = new Button("-4");
        Button aiko = new Button("aiko");
        Button bay_wolf_jr = new Button("bay wolf Jr");
        Button hard_back = new Button("back");

        final GridPane hard_grid = new GridPane();
        hard_grid.setAlignment(Pos.CENTER_LEFT);
        hard_grid.setHgap(10);
        hard_grid.setVgap(10);
        hard_grid.setPadding(new Insets(25, 25, 25, 25));
        hard_grid.add(t_karino, 0, 0);
        hard_grid.add(minus_4, 0, 1);
        hard_grid.add(aiko, 0, 2);
        hard_grid.add(bay_wolf_jr, 0, 3);
        hard_grid.add(hard_back, 1, 5);
        final Scene hard_scene = new Scene(hard_grid, 300, 275);


        t_karino.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\t_karino"));
                gameVC.show(primarystage);
            }
        });
        minus_4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\minus_4"));
                gameVC.show(primarystage);
            }
        });
        aiko.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\aiko"));
                gameVC.show(primarystage);
            }
        });
        bay_wolf_jr.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                GameVC_2 gameVC = new GameVC_2(primarystage,loadPuzzle("puzzles\\bay_wolf_jr"));
                gameVC.show(primarystage);
            }
        });


        easy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = easy_scene;
                show(primarystage);
            }
        });

        medium.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = medium_scene;
                show(primarystage);
            }
        });

        hard.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = hard_scene;
                show(primarystage);
            }
        });

        Button back = new Button();
        back.setText("back");
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                MainVC main = new MainVC(primarystage);
                main.show(primarystage);
            }
        });

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(easy, 0, 0);
        root.add(medium, 0, 1);
        root.add(hard, 0, 2);
        root.add(back, 1, 3);
        final Scene root_scene = new Scene(root, 300, 275);

        easy_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = root_scene;
                show(primarystage);
            }
        });
        medium_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = root_scene;
                show(primarystage);
            }
        });
        hard_back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                scene = root_scene;
                show(primarystage);
            }
        });


        scene = root_scene;
    }

    public void show(Stage stage) {
        stage.setTitle("Puzzles");
        stage.setScene(scene);
        stage.show();
    }

    public Puzzle loadPuzzle(String filename){
        Puzzle puzzle;
        try{
// Open file to read from, named SavedObj.sav.
            FileInputStream loadFile = new FileInputStream(filename+".pzl");

// Create an ObjectInputStream to get objects from save file.
            ObjectInputStream load = new ObjectInputStream(loadFile);

// Now we do the restore.
// readObject() returns a generic Object, we cast those back
// into their original class type.
// For primitive types, use the corresponding reference class.
            puzzle = (Puzzle) load.readObject();
// Close the file.
            load.close(); // This also closes saveFile.
            for(int x =0; x<puzzle.getWidth();x++){
                for(int y = 0; y<puzzle.getHeight();y++){
                    OwnList pairs = new OwnList();
                    for(int i =0; i<puzzle.getWidth();i++) {
                        for (int j = 0; j < puzzle.getHeight(); j++) {
                            if(puzzle.getCountry(x,y) == puzzle.getCountry(i,j)){
                                pairs.add(new Pair(i,j));
                            }
                        }
                    }
                    Pair[] pairs2 = pairs.toArray();
                    puzzle.setNeighbors(pairs2, x, y);
                }
            }
            return puzzle;
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
            return null;
        }
    }
}
