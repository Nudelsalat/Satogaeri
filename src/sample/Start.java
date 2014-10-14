package sample;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Cloud on 14.10.2014.
 */
public class Start extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        TestModel testModel = new TestModel(primaryStage);

        //GameVC_V2 gameVC = new GameVC_V2(testModel);
        //gameVC.show();
    }
}
