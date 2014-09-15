package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
public class Generator extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception{
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

        Label userName = new Label("Height:");
        root.add(userName, 0, 1);

        final TextField height = new TextField();
        root.add(height, 1, 1);

        Label pw = new Label("Width:");
        root.add(pw, 0, 2);

        final TextField width = new TextField();
        root.add(width, 1, 2);

        root.add(hbBtn,1,3);

        final Text action_target = new Text();
        root.add(action_target, 1, 5);

        generate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String height_input = height.getCharacters().toString();
                String width_input = width.getCharacters().toString();
                if(!height_input.matches("\\d+")){
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Height must be a positive Number");
                }else if(!width_input.matches("\\d+")){
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Width must be a positive Number");
                }else{
                    action_target.setFill(Color.FIREBRICK);
                    action_target.setText("Generation in progress...");
                    //TODO: start the generation && maybe check if the number is exorbitant high...
                }
            }
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
