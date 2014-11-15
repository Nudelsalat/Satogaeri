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
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * Created by Cloud on 17.09.2014.
 *
 *
 */
public class GameVC_2 {

    Puzzle puzzle;
    Puzzle startLayoutPuzzle;
    Puzzle clone;

    Stage primaryStage;
    Boolean trymode = false;

    public GameVC_2(final Stage primaryStage, Puzzle puzzle) {
        this.puzzle = puzzle;
        //this.primaryStage = primaryStage;
        startLayoutPuzzle = puzzle.clonePuzzle();
    }

    public void draw(final Puzzle puzzle, final Stage primaryStage) {
        int height = 30;
        int width = 30;

// ### winning Popup start ###
        final Text hello = new Text();
        hello.setText("Congratz! You are victorious.");
        hello.setFont(Font.font(24));
        final Text errorMessage = new Text();
        Button ok = new Button("Back to Mainmenu");

        VBox popUpVBox = new VBox();
        popUpVBox.getChildren().add(hello);
        popUpVBox.getChildren().add(ok);
        popUpVBox.getChildren().add(errorMessage);
        popUpVBox.setStyle("-fx-background-color: #FF00FF;");

        final Popup popup = new Popup();
        popup.setAutoFix(false);
        popup.setHideOnEscape(true);
        popup.getContent().addAll(popUpVBox);
        popup.setX(500);
        popup.setY(255);

        ok.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                errorMessage.setText("back to menu not done yet....");

            }
        });
// ### winning popup end ###


        final GridPane gameGrid = new GridPane();

        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                puzzle.overwritePuzzle(startLayoutPuzzle);
                puzzle.clearLog();
                trymode = false;
                draw(puzzle, primaryStage);
            }
        });

        Button btnUndo = new Button();
        btnUndo.setText("Undo");
        btnUndo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (!puzzle.logListIsEmpty()) {
                    puzzle.logListGet();
                }
                draw(puzzle, primaryStage);
            }
        });

        Button btnCheck = new Button();
        btnCheck.setText("Check");
        btnCheck.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (puzzle.check()) {
                    //TODO congratz you're ze winner field + back to main menu
                    popup.show(primaryStage);
                }
            }
        });

        Button btnTry = new Button();
        btnTry.setText("Try");
        btnTry.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                clone = puzzle.clonePuzzle();
                trymode = true;
                draw(puzzle, primaryStage);
            }
        });

        Button btnFix = new Button();
        btnFix.setText("Fix");
        btnFix.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                trymode = false;
                draw(puzzle, primaryStage);
            }
        });

        Button btnDelete = new Button();
        btnDelete.setText("Delete");
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                puzzle.overwritePuzzle(clone);
                trymode = false;
                draw(puzzle, primaryStage);
            }
        });

        GridPane btnGrid = new GridPane();
        btnGrid.setAlignment(Pos.CENTER_LEFT);
        btnGrid.setHgap(10);
        btnGrid.add(btnClear, 0, 0);
        btnGrid.add(btnUndo, 1, 0);
        btnGrid.add(btnCheck, 2, 0);
        if (!trymode) {
            btnGrid.add(btnTry, 3, 0);
        } else {
            btnGrid.add(btnFix, 3, 0);
            btnGrid.add(btnDelete, 4, 0);
        }

        GridPane rootGrid = new GridPane();
        final Scene scene = new Scene(rootGrid);
        gameGrid.setAlignment(Pos.CENTER);
        gameGrid.setPadding(new Insets(25, 25, 25, 25));
        //gameGrid.add(new_game, 0, 0);
        for (int x = 1; x < puzzle.getWidth() * 2; x++) {
            for (int y = 1; y < puzzle.getHeight() * 2; y++) {
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        final Rectangle point = new Rectangle(x, y, 2, 2);
                        point.setFill(Color.GREY);
                        gameGrid.add(point, x, y);
                    } else {
                        final Rectangle line = new Rectangle(x, y, width, 2);
                        // out of bounds should not happen, because
                        if (puzzle.getCountry(x / 2, (y / 2) - 1) != puzzle.getCountry(x / 2, y / 2)) {
                            line.setFill(Color.BLACK);
                        } else {
                            line.setFill(Color.WHITE);
                        }
                        gameGrid.add(line, x, y);
                    }
                } else if (y % 2 != 0 && x % 2 == 0) {
                    final Rectangle line = new Rectangle(x, y, 2, height);
                    // out of bounds should not happen, because we don't check outer borders
                    if (puzzle.getCountry((x / 2) - 1, y / 2) != puzzle.getCountry(x / 2, y / 2)) {
                        line.setFill(Color.BLACK);
                    } else {
                        line.setFill(Color.WHITE);
                    }
                    gameGrid.add(line, x, y);
                } else {
                    final Rectangle drag_to = new Rectangle(x, y, width, height);
                    if (puzzle.getInhabited(x / 2, y / 2)) {
                        drag_to.setFill(Color.LIGHTGREEN);
                    } else {
                        drag_to.setFill(Color.AQUA);
                    }
                    drag_to.setId("f" + x + "-" + y);
                    gameGrid.add(drag_to, x, y);
                    drag_to.setOnDragOver(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                /* data is dragged over the target */
                            //System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                            if (event.getGestureSource() != drag_to &&
                                    event.getDragboard().hasString()) {
                    /* allow for both copying and moving, whatever user chooses */
                                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                            }

                            event.consume();
                        }
                    });

                    drag_to.setOnDragEntered(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                            System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                            if (event.getGestureSource() != drag_to &&
                                    event.getDragboard().hasString()) {
                                drag_to.setFill(Color.BLUE);
                                System.out.println("x= " + drag_to.getX() + "\ny= " + drag_to.getY());
                            }

                            event.consume();
                        }
                    });

                    drag_to.setOnDragExited(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                            drag_to.setFill(Color.AQUA);
                            event.consume();
                        }
                    });

                    drag_to.setOnDragDropped(new EventHandler<DragEvent>() {
                        public void handle(DragEvent event) {
                /* data dropped */
                            System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                            Dragboard db = event.getDragboard();
                            boolean success = false;
                            if (db.hasString()) {
                                System.out.println("string is: " + db.getString());
                                String[] circlevalue = parseResult(db.getString());
                                System.out.println(circlevalue[0] + " " + circlevalue[1]);
                                success = puzzle.move(Integer.parseInt(circlevalue[0]) / 2, Integer.parseInt(circlevalue[1]) / 2, ((int) drag_to.getX()) / 2, ((int) drag_to.getY()) / 2);
                                if (success) {
                                    puzzle.logListAdd(((int) drag_to.getX()) / 2, ((int) drag_to.getY()) / 2, Integer.parseInt(circlevalue[0]) / 2, Integer.parseInt(circlevalue[1]) / 2);
                                }
                                System.out.println("Success = " + success);
                            }
                /* let the source know whether the string was successfully
                 * transferred and used */
                            event.setDropCompleted(success);

                            event.consume();
                        }
                    });


                }
            }
        }

        /* Add circles to the field
         */
        for (int x = 1; x < puzzle.getWidth() * 2; x = x + 2) {
            for (int y = 1; y < puzzle.getHeight() * 2; y = y + 2) {
                if (puzzle.getCircle_trace(x / 2, y / 2) != -1) {
                    final Text source = new Text(20, 20, "" + puzzle.getCircleToString(x / 2, y / 2));
                    if (puzzle.getHas_moved(x / 2, y / 2)) {
                        source.setFill(Color.RED);
                    }
                    if (puzzle.getCircle_value(x / 2, y / 2) != -1) {
                        // TODO: center does not work
                        source.setTextAlignment(TextAlignment.CENTER);
                        source.setId("X:" + x + "Y:" + y);
                        source.setOnDragDetected(new EventHandler<MouseEvent>() {
                            public void handle(MouseEvent event) {
                    /* drag was detected, start drag-and-drop gesture*/
                                //System.out.println("onDragDetected");

                    /* allow any transfer mode */
                                Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                    /* put a string on dragboard */
                                ClipboardContent content = new ClipboardContent();
                                content.putString(source.getId());
                                db.setContent(content);

                                event.consume();
                            }
                        });
                        source.setOnDragDone(new EventHandler<DragEvent>() {
                            public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                                System.out.println("onDragDone");
                    /* if the data was successfully moved, clear it */
                                if (event.getTransferMode() == TransferMode.MOVE) {
                                    source.setText("");
                                }
                                draw(puzzle, primaryStage);
                                event.consume();
                            }
                        });
                    }
                    gameGrid.add(source, x, y);
                }
            }
        }

        rootGrid.add(btnGrid, 0, 0);
        rootGrid.add(gameGrid, 0, 1);

        primaryStage.setTitle("Satogaeri");
        primaryStage.setScene(scene);
        primaryStage.show();
        puzzle.print();
    }

    public void show(Stage stage){
        primaryStage = stage;
        draw(puzzle,stage);
    }

    static public String[] parseResult(String string) {
        String pattern = "(X:)(\\d+)(Y:)(\\d+)";
        String pattern2 = ";";
        string = string.replaceAll(pattern, "$2;$4");

        return string.split(pattern2);
    }
}

