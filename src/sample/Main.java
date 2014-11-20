package sample;


import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(final Stage primaryStage) throws Exception{
        MainVC main = new MainVC(primaryStage);
        main.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
