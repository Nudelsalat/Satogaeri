package sample;

import Solver.OwnList;
import Solver.Pair;
import Solver.Puzzle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class MainVC{
    private Stage primaryStage;

    
    MainVC(final Stage primaryStage, final String path){
        this.primaryStage = primaryStage;
        Button new_game = new Button();
        Button generate = new Button();
        Button solve = new Button();
        Button loadbtn = new Button();
        new_game.setText("Start new Game");
        new_game.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Puzzles puzzles = new Puzzles(primaryStage,path);
                puzzles.show(primaryStage);
                System.out.println("game in progress...");
            }
        });

        generate.setText("Puzzle Generator");
        generate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Generator generator = new Generator(primaryStage,path);
                generator.show(primaryStage);
                }
        });

        solve.setText("Drawing");
        solve.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Drawing drawing = new Drawing(primaryStage,path);
                drawing.show(primaryStage);
            }
        });

        loadbtn.setText("Load a puzzle");
        loadbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(
                        new File(System.getProperty("user.dir"))
                );
                fileChooser.setTitle("Open Puzzle File");
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    System.out.println("file is "+file.toString());
                    GameVC_2 gameVC = new GameVC_2(primaryStage,loadPuzzle(file.toString()));
                    gameVC.show(primaryStage);
                }
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
    public void show(Stage stage){
        primaryStage = stage;
        primaryStage.show();
    }

    public Puzzle loadPuzzle(String filename){
        Puzzle puzzle;
        try{
// Open file to read from, named SavedObj.sav.
            FileInputStream loadFile = new FileInputStream(filename);

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
