package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;


import java.io.File;

/**
 * Created by Cloud on 24.11.2014.
 */
public class ChooseSolverVC {
    private Stage primaryStage;
    public ChooseSolverVC(final Stage primaryStage){
        this.primaryStage = primaryStage;

        final Label pathLabel = new Label();
        pathLabel.setText("Path to Solver:");
        final TextField pathTextField = new TextField();

        final Label parameterLabel = new Label();
        parameterLabel.setText("Additional Parameters:");
        final TextField parameterTextField = new TextField();
        final Text parameterText = new Text("For example: \nfor CVC4 \"--lang smt -m\" is mandatory.");

        final Text errorMessage = new Text();
        Button btnOk = new Button("OK");

        btnOk.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (pathTextField.getText().equals("")) {
                    errorMessage.setText("Please enter a Path to a Solver.");
                    errorMessage.setFill(Color.FIREBRICK);
                }else{
                    //TODO stuff
                    String string = pathTextField.getText()+" "+parameterTextField.getText();
                    MainVC mainVC = new MainVC(primaryStage,string);
                    mainVC.show(primaryStage);
                }
            }
        });
// end popup
        Button loadbtn = new Button();
        loadbtn.setText("Load Solver");
        loadbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(
                        new File(System.getProperty("user.dir"))
                );
                fileChooser.setTitle("Load Solver");
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    System.out.println("file is " + file.toString());
                    pathTextField.setText(file.toString());

                }
            }
            });
        GridPane root = new GridPane();
        Text title = new Text(1.5,2.5,"Choose your Solver");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFill(Color.BLUEVIOLET);
        title.setFont(Font.font(26));
        //root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.add(title,0,0);
        root.add(pathLabel,0,1);
        root.add(pathTextField,1,1);
        root.add(loadbtn,2,1);
        root.add(parameterLabel,0,2);
        root.add(parameterTextField,1,2);
        root.add(parameterText,0,3);
        root.add(errorMessage,0,4);
        root.add(btnOk,2,5);

        primaryStage.setTitle("Satogaeri");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        }


    public void show(Stage stage){
        primaryStage = stage;
        primaryStage.show();
    }
}

