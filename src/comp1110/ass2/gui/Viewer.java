package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * A very simple viewer for piece placements in the twist game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    /* board layout */
    private static final int SQUARE_SIZE = 60;
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group pieces = new Group();
    private final Group controls = new Group();
    TextField textField;

    /**
     * An inner class that represents pieces and pegs which are going to draw in the scene.
     * Each of these is a visual representation of a piece or peg.
     */
    class pnp extends ImageView{
        char key;

        /**
         * Construct a particular piece or peg
         *
         * @param key The character representing of the piece or peg.
         */
        pnp(char key) {
            this.key = key;

            if (key >= 'm') {
                throw new IllegalArgumentException("Bad input: \"" + key + "\"");
            }

            setImage(new Image(Viewer.class.getResource(URI_BASE + key + ".png").toString()));

            if (key =='a'||key =='b'||key=='d'||key=='f'){
                setFitHeight(SQUARE_SIZE*2);
                setFitWidth(SQUARE_SIZE*3);
            }else if(key =='i'||key =='j'||key=='k'||key=='l'){
                setFitHeight(SQUARE_SIZE);
                setFitWidth(SQUARE_SIZE);
            }else {
                switch (key){
                    case 'c':
                        setFitHeight(SQUARE_SIZE);
                        setFitWidth(SQUARE_SIZE*4);
                        break;
                    case 'e':
                        setFitHeight(SQUARE_SIZE*2);
                        setFitWidth(SQUARE_SIZE*2);
                        break;
                    case 'g':
                        setFitHeight(SQUARE_SIZE*3);
                        setFitWidth(SQUARE_SIZE*3);
                        break;
                    case 'h':
                        setFitHeight(SQUARE_SIZE*1);
                        setFitWidth(SQUARE_SIZE*3);
                        break;
                }
            }
        }

    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    void makePlacement(String placement) {

        // FIXME Task 4: implement the simple placement viewer
    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TwistGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);
        root.getChildren().add(pieces);

        makeControls();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}