package sample;

import Solver.Puzzle;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Created by Cloud on 17.09.2014.
 */
public class GameVC_V2 {

    private TestModel testModel;

    private Puzzle puzzle;

    private GameView gameView;


    public GameVC_V2(TestModel testModel) throws Exception {

        this.testModel = testModel;
        this.puzzle = testModel.getPuzzle();

        //Button new_game = new Button();
        //new_game.setText("Start new Game");
        /*new_game.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("game in progress...");
            }
        });
*/
    }

    public void show() {
        gameView.show(testModel.getPrimaryStage());
    }


    static public String[] parseResult(String string) {
        String pattern = "(X:)(\\d+)(Y:)(\\d+)";
        String pattern2 = ";";
        string = string.replaceAll(pattern, "$2;$4");

        return string.split(pattern2);
    }
}
