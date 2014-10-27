package sample;

import Solver.Pair;
import Solver.Puzzle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Created by Cloud on 23.10.2014.
 */
public class DrawVC extends Application{

    private int height;
    private int width;
    private Puzzle puzzle;
    private int countryCounter = 1;
    private int circleCounter = 1;
    private int input = -1;
    private int xCoordinate;
    private int yCoordinate;

    public enum Drawmode {COUNTRY, CIRCLE};

    private Drawmode drawmode = Drawmode.COUNTRY;


    @Override
    public void start(final Stage primaryStage) throws Exception{

        height=18;
        width=10;

        puzzle = new Puzzle(height,width);

        draw(puzzle, primaryStage);
    }

    public void draw(final Puzzle puzzle, final Stage primaryStage) {

//Popup
        final Label hello = new Label();
        final TextField popupTextfield = new TextField();
        final Text errorMessage = new Text();
        Button ok = new Button("ok");

        VBox popUpVBox = new VBox();
        popUpVBox.getChildren().add(hello);
        popUpVBox.getChildren().add(popupTextfield);
        popUpVBox.getChildren().add(ok);
        popUpVBox.getChildren().add(errorMessage);
        //popUpVBox.setStyle("-fx-background-color: #FFFFFF;");

        final Popup popup = new Popup();
        popup.setAutoFix(false);
        popup.setHideOnEscape(true);
        popup.getContent().addAll(popUpVBox);
        popup.setX(250);
        popup.setY(175);

        ok.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (popupTextfield.getText().equals("#")) {
                    puzzle.setCircle(new Pair(xCoordinate, yCoordinate), -2, circleCounter);
                    circleCounter++;
                    System.out.println("Next Circle ID= " + circleCounter);
                    popup.hide();
                    draw(puzzle, primaryStage);
                } else {
                    try {
                        input = Integer.parseInt(popupTextfield.getText());
                        if (input <= -1) {
                            puzzle.setCircle(new Pair(xCoordinate, yCoordinate), -1, -1);
                        } else {
                            puzzle.setCircle(new Pair(xCoordinate, yCoordinate), input, circleCounter);
                        }
                        circleCounter++;
                        System.out.println("Next Circle ID= " + circleCounter);
                        popup.hide();
                        draw(puzzle, primaryStage);
                    } catch (Exception e) {
                        errorMessage.setText("Input has to be Integer or '#' !\n" +
                                "Negative numbers will do nothing OR delete the current number.");
                        errorMessage.setFill(Color.FIREBRICK);
                    }
                }
            }
        });
// end popup

        Button btnCountry = new Button();
        btnCountry.setText("Draw Country");
        btnCountry.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                drawmode = Drawmode.COUNTRY;
                System.out.println("Drawmode: " + drawmode.toString());
            }
        });
        Button btnCircle = new Button();
        btnCircle.setText("Draw Circle");
        btnCircle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                drawmode = Drawmode.CIRCLE;
                System.out.println("Drawmode: " + drawmode.toString());
            }
        });

        Button btnSave = new Button();
        btnSave.setText("Save Puzzle");
        btnSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //TODO: Check if Puzzle is okay 'n stuff.
                puzzle.print();
                puzzle.savePuzzle("test");
            }
        });

        GridPane saveGrid = new GridPane();
        saveGrid.setAlignment(Pos.CENTER_RIGHT);
        saveGrid.add(btnSave,0,0);



        GridPane btnGrid = new GridPane();
        btnGrid.setAlignment(Pos.CENTER);
        btnGrid.setHgap(10);
        btnGrid.add(btnCircle,0,0);
        btnGrid.add(btnCountry,1,0);

        int height = 20;
        int width = 20;

        final GridPane gameGrid = new GridPane();
        GridPane superRoot = new GridPane();
        final Scene scene = new Scene(superRoot);
        superRoot.setPadding(new Insets(5, 5, 5, 5));
        superRoot.setAlignment(Pos.CENTER);
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setPadding(new Insets(25, 25, 25, 25));
        //gameGrid.setVgap(1);
        //gameGrid.setHgap(1);
        for (int x = 1; x < puzzle.getWidth()*2; x++) {
            for (int y = 1; y < puzzle.getHeight() * 2; y++) {
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        final Rectangle point = new Rectangle(x, y, 2, 2);
                        point.setFill(Color.WHITE);
                        gameGrid.add(point, x, y);
                    } else {
                        final Rectangle line = new Rectangle(x, y, width, 2);
                        // out of bounds should not happen, because
                        System.out.println("at "+x+" "+y+" Countrys are: "+puzzle.getCountry(x / 2, (y-1) / 2)+" and "+puzzle.getCountry(x / 2, (y + 1) / 2));
                        if (puzzle.getCountry(x / 2, (y/2)-1) != puzzle.getCountry(x / 2, y /2)) {
                            line.setFill(Color.BLACK);
                        } else {
                            line.setFill(Color.WHITE);
                        }
                        gameGrid.add(line, x, y);
                    }
                } else if (y % 2 != 0 && x % 2 == 0) {
                    final Rectangle line = new Rectangle(x, y, 2, height);
                    // out of bounds should not happen, because we don't check outer borders
                    if (puzzle.getCountry((x / 2)-1, y / 2) != puzzle.getCountry(x / 2, y / 2)) {
                        line.setFill(Color.BLACK);
                    } else {
                        line.setFill(Color.WHITE);
                    }
                    gameGrid.add(line, x, y);
                } else {
                    final Rectangle rectangle = new Rectangle(x, y, width, height);
                    if (puzzle.getCountry(x/2, y/2) != -1) {
                        rectangle.setFill(Color.LIGHTGREEN);
                    } else {
                        rectangle.setFill(Color.AQUA);
                    }
                    rectangle.setId("X:" + x + "Y:" + y);
                    gameGrid.add(rectangle, x, y);
//Country & Drag part:
                    rectangle.setOnDragDetected(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            if (drawmode == Drawmode.COUNTRY) {
                                Dragboard db = rectangle.startDragAndDrop(TransferMode.ANY);
                                ClipboardContent content = new ClipboardContent();
                                content.putString(rectangle.getId());
                                db.setContent(content);

                                Pair[] pair = new Pair[1];
                                pair[0] = new Pair(((int) rectangle.getX())/2, ((int) rectangle.getY())/2);
                                puzzle.setCountry(pair, countryCounter);
                            }
                            event.consume();
                        }
                    });

                    rectangle.setOnDragDone(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                            if (drawmode == Drawmode.COUNTRY) {
                    /* the drag-and-drop gesture ended */
                                System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */

                                countryCounter++;
                                System.out.println("Next Country has ID " + countryCounter);

                                draw(puzzle, primaryStage);
                            }
                            event.consume();
                        }
                    });

                    rectangle.setOnDragEntered(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                            if (drawmode == Drawmode.COUNTRY) {
                                Pair[] pair = new Pair[1];
                                pair[0] = new Pair(((int) rectangle.getX())/2, ((int) rectangle.getY())/2);
                                puzzle.setCountry(pair, countryCounter);

                                rectangle.setFill(Color.BLUE);
                                System.out.println("x= " + rectangle.getX()/2 + "\ny= " + rectangle.getY()/2);
                            }

                            event.consume();
                        }
                    });

// Circle & Click Part:
                    rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        public void handle(MouseEvent event) {
                            if (drawmode == Drawmode.CIRCLE) {
                                if (popup.isShowing()) {
                                    popup.hide();
                                } else {
                                    xCoordinate = ((int) rectangle.getX())/2;
                                    yCoordinate = ((int) rectangle.getY())/2;
                                    popup.show(primaryStage);

                                    rectangle.setFill(Color.RED);
                                }
                            }

                            event.consume();
                        }
                    });
                }
            }
        }



    /* Add circles to the field
     */
        for (int x = 1; x < puzzle.getWidth()*2; x=x+2) {
            for (int y = 1; y < puzzle.getHeight()*2; y=y+2) {
                if (puzzle.getCircle_trace(x/2, y/2) != -1) {
                    final Text source = new Text(20, 20,""+puzzle.getCircleToString(x/2, y/2));

                    if(puzzle.getCircle_value(x/2, y/2) != -1) {
                        // TODO: center does not work
                        source.setTextAlignment(TextAlignment.CENTER);
                        // TODO: Trace1Value-2 good idea?
                        source.setId("X:" + x + "Y:" + y);
                    }
                    gameGrid.add(source, x, y);
                }
            }
        }

        superRoot.add(btnGrid, 0, 0);
        superRoot.add(gameGrid, 0, 1);
        superRoot.add(saveGrid, 0 ,2);


        primaryStage.setTitle("Satogaeri");
        primaryStage.setScene(scene);
        primaryStage.show();
        puzzle.print();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
