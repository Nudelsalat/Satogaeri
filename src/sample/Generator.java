package sample;

import Solver.Puzzle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by Cloud on 15.09.2014.
 */
public class Generator{
    Scene scene;

    public Generator(final Stage primaryStage){
        Button generate = new Button("generate");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(generate);

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Generator");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(scenetitle, 0, 0, 2, 1);

        Label label_height = new Label("Height:");
        root.add(label_height, 0, 1);

        final TextField height = new TextField();
        root.add(height, 1, 1);

        Label label_width = new Label("Width:");
        root.add(label_width, 0, 2);

        final TextField width = new TextField();
        root.add(width, 1, 2);

        Label label_probability = new Label("Countrysize:");
        root.add(label_probability, 0, 3);

        final TextField probability = new TextField();
        probability.setText("0.8");
        root.add(probability, 1, 3);

        root.add(hbBtn,1,4);

        final Text action_target = new Text();
        root.add(action_target, 1, 5);

        generate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String height_input = height.getCharacters().toString();
                String width_input = width.getCharacters().toString();
                String prop_input = probability.getCharacters().toString();
                if (!height_input.matches("\\d+")) {
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Height must be a positive Number");
                } else if (!width_input.matches("\\d+")) {
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Width must be a positive Number");
                } else if(checkDouble(prop_input)) {
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Countrysize must be between\n0.0 and 1.0");
                } else{
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Generation in progress...");
                    //TODO: start the generation && maybe check if the number is exorbitant high...
                    Solver.Generator gen = new Solver.Generator(Integer.parseInt(width_input),Integer.parseInt(height_input), Double.parseDouble(prop_input));
                    Puzzle puzzle = gen.getPuzzle();
                    GameVC_2 gameVC = new GameVC_2(primaryStage, puzzle);
                    gameVC.show(primaryStage);
                }
            }
        });

        scene = new Scene(root, 300, 275);
    }

    public boolean checkDouble(String string){
        try{
            double number;
            number = Double.parseDouble(string);
            // neat!
            return (number >= 1.0 || number <=0.0);
        }catch(Exception e){
            return false;
        }
    }

    public void show(Stage stage){
        stage.setTitle("Generator");
        stage.setScene(scene);
        stage.show();
    }
}
