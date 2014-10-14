package sample;

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
import javafx.stage.Stage;

/**
 * Created by Cloud on 18.09.2014.
 */
public class GameView {
    private Scene scene;

    private GridPane root;



    public GameView() {
        int height = 20;
        int width = 20;

        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.setVgap(1);
        root.setHgap(1);
        //root.add(new_game, 0, 0);

//
//        for (int x = 0; x < puzzle.getWidth(); x++) {
//            for (int y = 0; y < puzzle.getHeight(); y++) {
//                final Rectangle drag_to = new Rectangle(x, y, width, height);
//                drag_to.setFill(Color.AQUA);
//                drag_to.setId("f" + x + "-" + y);
//                root.add(drag_to, x, y + 1);
//                drag_to.setOnDragOver(new EventHandler<DragEvent>() {
//                    public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                        //System.out.println("onDragOver");
//
//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                        if (event.getGestureSource() != drag_to &&
//                                event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                        }
//
//                        event.consume();
//                    }
//                });
//
//                drag_to.setOnDragEntered(new EventHandler<DragEvent>() {
//                    public void handle(DragEvent event) {
//                /* the drag-and-drop gesture entered the target */
//                        System.out.println("onDragEntered");
//                /* show to the user that it is an actual gesture target */
//                        if (event.getGestureSource() != drag_to &&
//                                event.getDragboard().hasString()) {
//                            drag_to.setFill(Color.BLUE);
//                            System.out.println("x= " + drag_to.getX() + "\ny= " + drag_to.getY());
//                        }
//
//                        event.consume();
//                    }
//                });
//
//                drag_to.setOnDragExited(new EventHandler<DragEvent>() {
//                    public void handle(DragEvent event) {
//                /* mouse moved away, remove the graphical cues */
//                        drag_to.setFill(Color.AQUA);
//                        event.consume();
//                    }
//                });
//
//                drag_to.setOnDragDropped(new EventHandler<DragEvent>() {
//                    public void handle(DragEvent event) {
//                /* data dropped */
//                        System.out.println("onDragDropped");
//                /* if there is a string data on dragboard, read it and use it */
//                        Dragboard db = event.getDragboard();
//                        boolean success = false;
//                        if (db.hasString()) {
//                            System.out.println("string is: " + db.getString());
//                            String[] circlevalue = parseResult(db.getString());
//                            System.out.println(circlevalue[0] + " " + circlevalue[1]);
//                            success = puzzle.move(Integer.parseInt(circlevalue[0]), Integer.parseInt(circlevalue[1]), (int) drag_to.getX(), (int) drag_to.getY());
//                            System.out.println("Success = " + success);
//                        }
//                /* let the source know whether the string was successfully
//                 * transferred and used */
//                        event.setDropCompleted(success);
//
//                        event.consume();
//                    }
//                });
//
//
//            }
//        }
//
//        /* Add circles to the field
//         */
//        for (int x = 0; x < puzzle.getWidth(); x++) {
//            for (int y = 0; y < puzzle.getHeight(); y++) {
//                if (puzzle.getCircle_trace(x, y) != -1 && puzzle.getCircle_value(x, y) != -1) {
//                    final Text source = new Text(20, 20, "" + puzzle.getCircle_value(x, y));
//                    // TODO: center does not work
//                    source.setTextAlignment(TextAlignment.CENTER);
//                    // TODO: Trace1Value-2 good idea?
//                    source.setId("X:" + x + "Y:" + y);
//                    source.setOnDragDetected(new EventHandler<MouseEvent>() {
//                        public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                            //System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                            Dragboard db = source.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                            ClipboardContent content = new ClipboardContent();
//                            content.putString(source.getId());
//                            db.setContent(content);
//
//                            event.consume();
//                        }
//                    });
//                    source.setOnDragDone(new EventHandler<DragEvent>() {
//                        public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                            System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                            if (event.getTransferMode() == TransferMode.MOVE) {
//                                source.setText("");
//                            }
//
//                            event.consume();
//                        }
//                    });
//
//                    root.add(source, x, y + 1);
//                }
//            }
//        }

        scene = new Scene(root, 300, 275);
    }
    public void show(Stage stage){
        stage.setTitle("Satogaeri");
        stage.setScene(scene);
        stage.show();

    }
}

