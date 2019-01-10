package comp1110.ass2.gui;

import comp1110.ass2.Objective;
import comp1110.ass2.TwistGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


import javafx.scene.image.ImageView;

import java.util.*;


public class Board extends Application {
    private static final int BOARD_WIDTH = 933;
    private static final int BOARD_HEIGHT = 700;
    private static final int SQUARE_SIZE = 60;
    private static final int MARGIN_X = 40;
    private static final int boardX = 220;
    private static final int boardY = 220;


    private static final String URI_BASE = "assets/";
    private static final String INSTRUCROr = Board.class.getResource(URI_BASE+"instructor.png").toString();
    private static final String BASEBOARD_URI = Board.class.getResource(URI_BASE + "board.png").toString();
    /* come form http://www.juimg.com/tupian/201110/diwenbeijing_119260.html*/
    private static final String BASEBACKGROUND_URI = Board.class.getResource(URI_BASE + "backGround.png").toString();

    /* come from http://www.juimg.com/tupian/201110/diwenbeijing_119260.html*/
    private static final String TITLE_URI=Board.class.getResource(URI_BASE + "title.png").toString();
    private static final int[] homex = {MARGIN_X-30,MARGIN_X-30,MARGIN_X-30,boardX+SQUARE_SIZE,boardX+SQUARE_SIZE*5,BOARD_WIDTH-MARGIN_X-3*SQUARE_SIZE+30
    ,BOARD_WIDTH-MARGIN_X-3*SQUARE_SIZE+30,BOARD_WIDTH-MARGIN_X-3*SQUARE_SIZE+30};
    private static final int[] homey = {50,250,500,50,
            50,500,250,50};

    /* Loop in public domain CC 0 http://www.freesound.org/people/oceanictrancer/sounds/211684/ */
    private static final String LOOP_URI = Board.class.getResource(URI_BASE + "211684__oceanictrancer__classic-house-loop-128-bpm.wav").toString();
    private AudioClip loop;

    private static final Group root = new Group();
    private static final Group pieces = new Group();
    private static final Group pegs = new Group();
    private final Group board = new Group();
    private final Group control =new Group();
    private final Group backGround = new Group();
    private final Group title = new Group();

    private static Pieces[] PS= new Pieces[8];

    private static String PEG="";
    private static int difficulity=0;
    private static int number=0;


    /* game variables */
    private boolean loopPlaying = false;


    /* message on completion */
    private final Text completionText = new Text("Well done!");

    /* message on completion */
    private final Text erroText = new Text("Please remove your last placement!");

    /* Define a drop shadow effect that we will appy to tiles */
    private static DropShadow dropShadow;


    /* the difficulty slider */
    private final Slider difficulty = new Slider();

    /* the under line game*/
    TwistGame twistGame;

    /* the state of the tiles */
    private static String[] piecesState = new String[8];   //  all off screen to begin with

    /* Static initializer to initialize dropShadow */
    {
        dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        dropShadow.setColor(Color.color(0, 0, 0, .4));
    }

    class  Pegs extends ImageView{
        char pegs;
        public Pegs(char p){
            this.pegs=p;
            setImage(new Image(Board.class.getResource(URI_BASE + p + ".png").toString()));
            setFitHeight(SQUARE_SIZE);
            setFitWidth(SQUARE_SIZE);
            setEffect(dropShadow);
        }
    }

    class Rectangular extends Polygon{
        double x ;
        double y;
        double side;
        Rectangular(double x ,double y, double Side){
            this.x=x;
            this.y=y;
            this.side=Side;
        }
    }

    class Pieces extends ImageView{
        char piece;
        boolean draggable;

        /**
         * Creates a new view that represents an IMG element.
         *
         * @param p the element to create a view for
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        public Pieces(char p,boolean draggable) {
            this.draggable=draggable;
            if (p>'h'){
                throw new IllegalArgumentException("Bad tile: \"" + p + "\"");
            }
            setImage(new Image(Board.class.getResource(URI_BASE + p + ".png").toString()));
            this.piece=p;

            //different pieces have different shapes.
            switch (p){
                case 'a':
                    setFitHeight(2*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
                case 'b':
                    setFitHeight(2*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
                    case 'c':
                    setFitHeight(1*SQUARE_SIZE);
                    setFitWidth(4*SQUARE_SIZE);
                    break;
                    case 'd':
                    setFitHeight(2*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
                    case 'e':
                    setFitHeight(2*SQUARE_SIZE);
                    setFitWidth(2*SQUARE_SIZE);
                    break;
                    case 'f':
                    setFitHeight(2*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
                    case 'g':
                    setFitHeight(3*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
                case 'h':
                    setFitHeight(1*SQUARE_SIZE);
                    setFitWidth(3*SQUARE_SIZE);
                    break;
            }
            setEffect(dropShadow);
        }
    }

    class draggablePieces extends Pieces{
        int homeX, homeY;           // the position in the window where the mask should be when not on the board
        double mouseX, mouseY;      // the last known mouse positions (used when dragging)

        /**
         * Creates a new view that represents an IMG element.
         *
         * @param p the element to create a view for
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        public draggablePieces(char p,boolean draggable) {
            super(p,draggable);
            piecesState[p-'a']="";
            int number = (int)p-'a';
            homeX = homex[number];
            homeY = homey[number];
            setLayoutX(homeX);
            setLayoutY(homeY);
            /* event handlers */
         //if (this.draggable==true){
            setOnScroll(event -> {            // scroll to change orientation
                hideCompletion();
               if (getLayoutX()==homeX){rotate();}
                event.consume();
            });

            setOnMouseClicked(event -> {
                if (event.getClickCount()==2){
                    hideCompletion();
                 if (getLayoutX()==homeX)  {flip();}
                    event.consume();}
            });


            setOnMousePressed(event -> {      // mouse press indicates begin of drag
                if (this.draggable==true){
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();}
            });
            setOnMouseDragged(event -> {      // mouse is being dragged
                hideCompletion();
                toFront();
                     if (this.draggable==true){
                double movementX = event.getSceneX() - mouseX;
                double movementY = event.getSceneY() - mouseY;

                setLayoutX(getLayoutX() + movementX);
                setLayoutY(getLayoutY() + movementY);
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();

                event.consume();            }
            });
            setOnMouseReleased(event -> {     // drag is complete
                snapToGrid();
            });
        }


        /**
         * Snap the tile to the nearest grid position (if it is over the grid)
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        private void snapToGrid() {
                int rotate = (int) getRotate();
                if (piece=='g'||piece=='e'||rotate==0||rotate==180){
                if ((getLayoutX() >= (boardX - (SQUARE_SIZE / 2))) && (getLayoutX() < (boardX + (SQUARE_SIZE / 2)))) {
                    setLayoutX(boardX);
                } else if ((getLayoutX() >= boardX + (SQUARE_SIZE / 2)) && (getLayoutX() < boardX + 1.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + SQUARE_SIZE);
                } else if ((getLayoutX() >= boardX + 1.5 * SQUARE_SIZE) && (getLayoutX() < boardX + 2.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + 2 * SQUARE_SIZE);
                }else if ((getLayoutX() >= boardX + 2.5 * SQUARE_SIZE) && (getLayoutX() < boardX + 3.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + 3 * SQUARE_SIZE);
                }else if ((getLayoutX() >= boardX + 3.5 * SQUARE_SIZE) && (getLayoutX() < boardX + 4.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + 4 * SQUARE_SIZE);
                }else if ((getLayoutX() >= boardX + 4.5 * SQUARE_SIZE) && (getLayoutX() < boardX + 5.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + 5 * SQUARE_SIZE);
                }else if ((getLayoutX() >= boardX + 5.5 * SQUARE_SIZE) && (getLayoutX() < boardX + 6.5 * SQUARE_SIZE)) {
                    setLayoutX(boardX + 6 * SQUARE_SIZE);
                }

                if ((getLayoutY() >= (boardY - (SQUARE_SIZE / 2))) && (getLayoutY() < (boardY + (SQUARE_SIZE / 2)))) {
                    setLayoutY(boardY);
                } else if ((getLayoutY() >= boardY + (SQUARE_SIZE / 2)) && (getLayoutY() < boardY + 1.5 * SQUARE_SIZE)) {
                    setLayoutY(boardY + SQUARE_SIZE);
                } else if ((getLayoutY() >= boardY + 1.5 * SQUARE_SIZE) && (getLayoutY() < boardY + 2.5 * SQUARE_SIZE)) {
                    setLayoutY(boardY + 2 * SQUARE_SIZE);
                } else if ((getLayoutY() >= boardY + 2.5 * SQUARE_SIZE) && (getLayoutY() < boardY + 3.5 * SQUARE_SIZE)) {
                    setLayoutY(boardY + 3 * SQUARE_SIZE);
                }
                }

                if (piece=='a'||piece=='b'||piece=='d'||piece=='f'){
                    if (rotate==90||rotate==270){
                        if ((getLayoutX() >= (boardX  -SQUARE_SIZE/2-(SQUARE_SIZE / 2))) && (getLayoutX() < (boardX -SQUARE_SIZE/2+ (SQUARE_SIZE / 2)))) {
                            setLayoutX(boardX-SQUARE_SIZE/2);
                        } else if ((getLayoutX() >= boardX-SQUARE_SIZE/2 + (SQUARE_SIZE / 2)) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX -SQUARE_SIZE/2+ SQUARE_SIZE);
                        } else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX -SQUARE_SIZE/2+ 2 * SQUARE_SIZE);
                        }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 3.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX -SQUARE_SIZE/2+ 3 * SQUARE_SIZE);
                        }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 3.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 4.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX -SQUARE_SIZE/2+ 4 * SQUARE_SIZE);
                        }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 4.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 5.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX-SQUARE_SIZE/2 + 5 * SQUARE_SIZE);
                        }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 5.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE/2+ 6.5 * SQUARE_SIZE)) {
                            setLayoutX(boardX-SQUARE_SIZE/2 + 6 * SQUARE_SIZE);
                        }

                        if ((getLayoutY() >= (boardY +SQUARE_SIZE/2- (SQUARE_SIZE / 2))) && (getLayoutY() < (boardY +SQUARE_SIZE/2+ (SQUARE_SIZE / 2)))) {
                            setLayoutY(boardY+SQUARE_SIZE/2);
                        } else if ((getLayoutY() >= boardY +SQUARE_SIZE/2+ (SQUARE_SIZE / 2)) && (getLayoutY() < boardY +SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE)) {
                            setLayoutY(boardY +SQUARE_SIZE/2+ SQUARE_SIZE);
                        } else if ((getLayoutY() >= boardY+SQUARE_SIZE/2 + 1.5 * SQUARE_SIZE) && (getLayoutY() < boardY +SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE)) {
                            setLayoutY(boardY +SQUARE_SIZE/2+ 2 * SQUARE_SIZE);
                        }
                    }

                }

            if (piece=='c'){
                if (rotate==90||rotate==270){
                    if ((getLayoutX() >= (boardX  -3*SQUARE_SIZE/2-(SQUARE_SIZE / 2))) && (getLayoutX() < (boardX -3*SQUARE_SIZE/2+ (SQUARE_SIZE / 2)))) {
                        setLayoutX(boardX-3*SQUARE_SIZE/2);
                    } else if ((getLayoutX() >= boardX-3*SQUARE_SIZE/2 + (SQUARE_SIZE / 2)) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -3*SQUARE_SIZE/2+ SQUARE_SIZE);
                    } else if ((getLayoutX() >= boardX -3*SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -3*SQUARE_SIZE/2+ 2 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -3*SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 3.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -3*SQUARE_SIZE/2+ 3 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 3.5 * SQUARE_SIZE) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 4.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -3*SQUARE_SIZE/2+ 4 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -3*SQUARE_SIZE/2+ 4.5 * SQUARE_SIZE) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 5.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX-3*SQUARE_SIZE/2 + 5 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -3*SQUARE_SIZE/2+ 5.5 * SQUARE_SIZE) && (getLayoutX() < boardX -3*SQUARE_SIZE/2+ 6.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX-3*SQUARE_SIZE/2 + 6 * SQUARE_SIZE);
                    }

                    if ((getLayoutY() >= (boardY +3*SQUARE_SIZE/2- (SQUARE_SIZE / 2))) && (getLayoutY() < (boardY +3*SQUARE_SIZE/2+ (SQUARE_SIZE / 2)))) {
                        setLayoutY(boardY+3*SQUARE_SIZE/2);
                    } else if ((getLayoutY() >= boardY +3*SQUARE_SIZE/2+ (SQUARE_SIZE / 2)) && (getLayoutY() < boardY +3*SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE)) {
                        setLayoutY(boardY +3*SQUARE_SIZE/2+ SQUARE_SIZE);
                    } else if ((getLayoutY() >= boardY+3*SQUARE_SIZE/2 + 1.5 * SQUARE_SIZE) && (getLayoutY() < boardY +3*SQUARE_SIZE/2+ 2.5 * SQUARE_SIZE)) {
                        setLayoutY(boardY +3*SQUARE_SIZE/2+ 2 * SQUARE_SIZE);
                    }
                }
            }

            if (piece=='h'){
                if (rotate==90||rotate==270){
                    if ((getLayoutX() >= (boardX  -SQUARE_SIZE-(SQUARE_SIZE / 2))) && (getLayoutX() < (boardX -SQUARE_SIZE+ (SQUARE_SIZE / 2)))) {
                        setLayoutX(boardX-SQUARE_SIZE);
                    } else if ((getLayoutX() >= boardX-SQUARE_SIZE + (SQUARE_SIZE / 2)) && (getLayoutX() < boardX -SQUARE_SIZE+ 1.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -SQUARE_SIZE+ SQUARE_SIZE);
                    } else if ((getLayoutX() >= boardX -3*SQUARE_SIZE/2+ 1.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 2.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -SQUARE_SIZE+ 2 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE+ 2.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 3.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -SQUARE_SIZE+ 3 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE/2+ 3.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 4.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX -SQUARE_SIZE+ 4 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE+ 4.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 5.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX-SQUARE_SIZE + 5 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE+ 5.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 6.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX-SQUARE_SIZE + 6 * SQUARE_SIZE);
                    }else if ((getLayoutX() >= boardX -SQUARE_SIZE+ 6.5 * SQUARE_SIZE) && (getLayoutX() < boardX -SQUARE_SIZE+ 7.5 * SQUARE_SIZE)) {
                        setLayoutX(boardX-SQUARE_SIZE + 7 * SQUARE_SIZE);
                    }

                    if ((getLayoutY() >= (boardY +SQUARE_SIZE- (SQUARE_SIZE / 2))) && (getLayoutY() < (boardY +SQUARE_SIZE+ (SQUARE_SIZE / 2)))) {
                        setLayoutY(boardY+SQUARE_SIZE);
                    } else if ((getLayoutY() >= boardY +SQUARE_SIZE+ (SQUARE_SIZE / 2)) && (getLayoutY() < boardY +SQUARE_SIZE+ 1.5 * SQUARE_SIZE)) {
                        setLayoutY(boardY +SQUARE_SIZE+ SQUARE_SIZE);
                    } else if ((getLayoutY() >= boardY+SQUARE_SIZE + 1.5 * SQUARE_SIZE) && (getLayoutY() < boardY +SQUARE_SIZE+ 2.5 * SQUARE_SIZE)) {
                        setLayoutY(boardY +SQUARE_SIZE+ 2 * SQUARE_SIZE);
                    }
                }
            }


                setPosition();


            if (onBoard()==false){
                snapToHome();
            }
            updateAndCheck();
        }

        /**
         * Determine the grid-position of the origin of the tile
         * or -1 if it is off the grid, taking into account its rotation.
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        private void setPosition() {
                Double x =getLayoutX();
                Double y =getLayoutY();
                char t =piece;
                String type = Character.toString(t);
                char o = ' ';
                int row =0;
                int length=0;
                if (x!=homeX){
                if (getScaleY()==0||getScaleY()==1){
                    switch ((int)getRotate()){
                            case 0:
                                o='0';
                                break;
                            case 90:
                                o='1';
                                break;
                            case 180:
                                o='2';
                                break;
                            case 270:
                                o='3';
                                break;
                    }
                }else {
                    switch ((int)getRotate()) {
                        case 0:
                            o = '4';
                            break;
                        case 90:
                            o = '5';
                            break;
                        case 180:
                            o = '6';
                            break;
                        case 270:
                            o = '7';
                            break;
                    }
                }
                if (getLayoutX()!=homeX){
                    if (t=='a'||t=='b'||t=='d'||t=='f'){
                        switch ((int)getRotate()){
                            case 90:
                                x=x+SQUARE_SIZE/2;
                                y=y-SQUARE_SIZE/2;
                                break;
                            case 270:
                                x=x+SQUARE_SIZE/2;
                                y=y-SQUARE_SIZE/2;
                                break;
                        }
                    }else if (t=='c'){
                        if ((int)getRotate()==90||(int)getRotate()==270){
                            x=x+3*SQUARE_SIZE/2;
                            y=y-3*SQUARE_SIZE/2;
                        }
                    }else if (t=='h'){
                        if ((int)getRotate()==90||(int)getRotate()==270){
                            x=x+SQUARE_SIZE;
                            y=y-SQUARE_SIZE;
                        }
                    }
                }

                double index = (x-boardX)/SQUARE_SIZE+1;
                row=(int) Math.round(index);
                double indey = (y-boardY)/SQUARE_SIZE;
                length=(int)(Math.round(indey));
                String r = Integer.toString(row);
                char l = (char)( 'A'+length);
                String place = type+r+Character.toString(l)+Character.toString(o);
                piecesState[t-'a']=place;
            }else {
                    piecesState[t-'a']="";
                }
        }


        /**
         * @return true if the mask is on the board
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        private boolean onBoard() {
            if (getLayoutY()<boardY||getLayoutY()>boardY+3*SQUARE_SIZE){return false;}
            List<String> ll =new ArrayList<>();
            for (String str : piecesState){
                if (str!=null){
                ll.add(str);}
            }
            Collections.sort(ll);
            String placement ="";
            for (int i=0;i<ll.size();i++){
                   placement=placement+ll.get(i);
            }
            placement=placement+PEG;
            return TwistGame.isPlacementStringValid(placement);
        }

        /**
         * Snap the mask to its home position (if it is not on the grid)
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        private void snapToHome() {
            setLayoutX(homeX);
            setLayoutY(homeY);
            setRotate(0);
            piecesState[piece-'a']="";
        }

        private void flip(){
            if (getScaleY()==0){
                Double a = getRotate();
                setScaleY(-1);
                setRotate(a);
            }else {
            setScaleY(-1*getScaleY());
           }
           setPosition();
           updateAndCheck();
        }
        /**
         * Rotate the tile by 90 degrees (unless this is mask zero and there is a constraint on mask zero)
         * @author Siyu Jiang u6563175@anu.edu.au
         */
        private void rotate() {
            setRotate((getRotate() + 90) % 360);
            setPosition();
            updateAndCheck();
        }

    }


    /**
     * Check game completion and update status
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void updateAndCheck() {
         List<String> ll = new ArrayList<>();
        for (int i=0;i<8;i++){
            if (piecesState[i]!=""){
                ll.add(piecesState[i]);
            }
        }
        Collections.sort(ll);
        String index= "";
        for (int i=0;i<ll.size();i++){
            index=index+ll.get(i);
        }
        boolean finished = TwistGame.isPlacementStringValid(index);
        if (finished == false||ll.size()<8) return;
        else {
            showCompletion();
        }
    }

    /**
     * Set up each of the nine tiles
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makePieces() {
        pieces.getChildren().clear();
        int i =0;
        for (char m = 'a'; m < 'i'; m++) {
            draggablePieces d =new draggablePieces(m,true);
            pieces.getChildren().add(d);
            PS[i]=d;
            i=i+1;
        }
    }

    /**
     * given a difficulity String, make placement
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    public void placePieces(String placement){
        for (int i =0;i<placement.length();i=i+4){
            String place = placement.substring(i,i+4);
            char kind = place.charAt(0);
            int number = kind-'a';
            int row  =place.charAt(1)-'1';
            int length =place.charAt(2)-'A';
            int x = boardX+row*SQUARE_SIZE;
            int y = boardY+length*SQUARE_SIZE;

            //depending on different pieces adjust the layoutX and layoutY(changing the
            // rotation will influence will have influences on the pieces placement).
            if (kind<'i'){
                if (kind=='a'||kind=='b'||kind=='d'||kind=='f'){
                    switch (place.charAt(3)){
                        case '0':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '1':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+SQUARE_SIZE/2);
                            PS[number].setScaleY(1);
                            break;
                        case '2':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '3':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+SQUARE_SIZE/2);
                            PS[number].setScaleY(1);
                            break;
                        case '4':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '5':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+SQUARE_SIZE/2);
                            PS[number].setScaleY(-1);
                            break;
                        case '6':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '7':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+SQUARE_SIZE/2);
                            PS[number].setScaleY(-1);
                            break;
                    }
                }else if (kind=='e'||kind=='g'){
                    PS[number].setLayoutY(y);
                    PS[number].setLayoutX(x);
                    if (place.charAt(3)=='0'||place.charAt(3)=='4'){
                        PS[number].setRotate(0);
                    }
                    if (place.charAt(3)=='1'||place.charAt(3)=='5'){
                        PS[number].setRotate(90);
                    }
                    if (place.charAt(3)=='2'||place.charAt(3)=='6'){
                        PS[number].setRotate(180);
                    }
                    if (place.charAt(3)=='3'||place.charAt(3)=='7'){
                        PS[number].setRotate(270);
                    }
                    if (place.charAt(3)>'3'){
                        PS[number].setScaleY(-1);
                    }else {
                        PS[number].setScaleY(1);
                    }
                }else if (kind=='c'){
                    switch (place.charAt(3)){
                        case '0':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '1':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-3*SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+3*SQUARE_SIZE/2);
                            PS[number].setScaleY(1);
                            break;
                        case '2':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '3':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-3*SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+3*SQUARE_SIZE/2);
                            PS[number].setScaleY(1);
                            break;
                        case '4':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '5':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-3*SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+3*SQUARE_SIZE/2);
                            PS[number].setScaleY(-1);
                            break;
                        case '6':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '7':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-3*SQUARE_SIZE/2);
                            PS[number].setLayoutY(y+3*SQUARE_SIZE/2);
                            PS[number].setScaleY(-1);
                            break;
                    }
                }else if (kind=='h'){
                    switch (place.charAt(3)){
                        case '0':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '1':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-SQUARE_SIZE);
                            PS[number].setLayoutY(y+SQUARE_SIZE);
                            PS[number].setScaleY(1);
                            break;
                        case '2':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(1);
                            break;
                        case '3':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-SQUARE_SIZE);
                            PS[number].setLayoutY(y+SQUARE_SIZE);
                            PS[number].setScaleY(1);
                            break;
                        case '4':
                            PS[number].setRotate(0);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '5':
                            PS[number].setRotate(90);
                            PS[number].setLayoutX(x-SQUARE_SIZE);
                            PS[number].setLayoutY(y+SQUARE_SIZE);
                            PS[number].setScaleY(-1);
                            break;
                        case '6':
                            PS[number].setRotate(180);
                            PS[number].setLayoutX(x);
                            PS[number].setLayoutY(y);
                            PS[number].setScaleY(-1);
                            break;
                        case '7':
                            PS[number].setRotate(270);
                            PS[number].setLayoutX(x-SQUARE_SIZE);
                            PS[number].setLayoutY(y+SQUARE_SIZE);
                            PS[number].setScaleY(-1);
                            break;
                    }
                }
            }
        }
        double a = PS[7].getLayoutX();
        for (int i =0;i<placement.length();i=i+4){
            int t = placement.substring(i,i+4).charAt(0)-'a';
           if (t<8){
               piecesState[t]= placement.substring(i,i+4);
           }
        }
    }


    /**
     * place the pegs on the board
     * @param place
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    public void makePegs(String place){
        pegs.getChildren().clear();
        for (int i =0;i<place.length();i=i+4){
            Pegs p =new Pegs(place.substring(i,i+4).charAt(0));
            int y = (int)(place.substring(i,i+4).charAt(2)-'A');
            p.setLayoutY(boardY+y*SQUARE_SIZE);
            int x = (int)(place.substring(i,i+4).charAt(1)-'1');
            p.setLayoutX(boardX+x*SQUARE_SIZE);
            pegs.getChildren().add(p);
        }
    }

    /**
     * generate hint for the current placement
     *@author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeHint(){
      try{
        String placemet ="";
        int index = 0;
        for (String str : piecesState){
            if (str!=""&&str!=null){
                index=index+1;
            }
        }


        for (String s :piecesState){
            if (s!=null){
                placemet=placemet+s;
            }
        }
        List<String> ll = new ArrayList<>();
        for (String s :piecesState){
            if (s!=null){
                ll.add(s);
            }
        }

        if (index<=4){
            String solution =Objective.solution[number];
        Set<String> test = new HashSet<>();
        for (int i =0;i<solution.length();i=i+4){
            test.add(solution.substring(i,i+4));
        }
        for (int i =0;i<piecesState.length;i++){
            if (piecesState[i]!=null&&piecesState[i]!=""){
                test.add(piecesState[i]);
            }
        }
        if (test.size()>8){
            showerror();
        }else {
            for (int i = 0; i < solution.length(); i = i + 4) {
                String place = solution.substring(i, i + 4);
                if (!ll.contains(place)) {
                    placePieces(place);
                    break;
                }
            }
        }}else {
            String[] solu = TwistGame.getSolutions(placemet);
            if (solu==null){
                showerror();
            }else {
                String solution = solu[0];
                for (int i =0;i<solution.length();i=i+4){
                    String next = solution.substring(i,i+4);
                    if (!ll.contains(next)){
                        placePieces(next);
                        break;
                    }
                }
            }
        }
        updateAndCheck();} catch (NullPointerException e){
          
      }
    }

    /**
     * Set up the group that represents the places that make the board
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeBackGround() {
        board.getChildren().clear();

        ImageView baseboard = new ImageView();
        baseboard.setImage(new Image(BASEBACKGROUND_URI));
        baseboard.setFitWidth(BOARD_WIDTH);
        baseboard.setFitHeight(BOARD_HEIGHT);
        baseboard.setLayoutX(0);
        baseboard.setLayoutY(0);
        backGround.getChildren().add(baseboard);
    }

    /**
     * make title for the start scene.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeTitle(){
       // title.getChildren().clear();
        ImageView baseboard = new ImageView();
        baseboard.setImage(new Image(TITLE_URI));
        baseboard.setFitWidth(BOARD_WIDTH);
        baseboard.setFitHeight(BOARD_HEIGHT+100);
        baseboard.setLayoutX(0);
        baseboard.setLayoutY(-100);
        title.toFront();
        title.getChildren().add(baseboard);
    }

    /**
     * Set up the sound loop (to play when the 'M' key is pressed)
     */
    private void setUpSoundLoop() {
        try {
            loop = new AudioClip(LOOP_URI);
            loop.setCycleCount(AudioClip.INDEFINITE);
        } catch (Exception e) {
            System.err.println(":-( something bad happened (" + LOOP_URI + "): " + e);
        }
    }


    /**
     * Turn the sound loop on or off
     */
    private void toggleSoundLoop() {
        if (loopPlaying)
            loop.stop();
        else
            loop.play();
        loopPlaying = !loopPlaying;
    }

    /**
     * Set up the group that represents the places that make the board
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeBoard() {
        board.getChildren().clear();



        for (int i = 0;i<8;i++){
            for (int j =0;j<4;j++){
                Circle c  =new Circle(boardX+SQUARE_SIZE/2+i*SQUARE_SIZE,boardY+SQUARE_SIZE/2+j*SQUARE_SIZE,SQUARE_SIZE/2-12);
                c.setFill(Color.GRAY);
                board.getChildren().add(c);
            }
        }


}

    /**
     * Create the controls that allow the game to be restarted and the difficulty
     * level set.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeControls() {
        Button button = new Button("Restart");
        button.setLayoutX(600);
        button.setLayoutY(550);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {newGame();}
        });
        control.getChildren().add(button);

        difficulty.setMin(1);
        difficulty.setMax(4);
        difficulty.setValue(0);
        difficulty.setShowTickLabels(true);
        difficulty.setShowTickMarks(true);
        difficulty.setMajorTickUnit(1);
        difficulty.setMinorTickCount(1);
        difficulty.setSnapToTicks(true);

        difficulty.setLayoutX(550);
        difficulty.setLayoutY(600);
        control.getChildren().add(difficulty);

        final Label difficultyCaption = new Label("Difficulty:");
        difficultyCaption.setTextFill(Color.BLACK);
        difficultyCaption.setLayoutX(450);
        difficultyCaption.setLayoutY(600);
        control.getChildren().add(difficultyCaption);
    }
    /**
     * Show the completion message
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void showCompletion() {
        completionText.toFront();
        completionText.setOpacity(1);
    }

    /**
     * Create the message to be displayed when the player completes the puzzle.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeCompletion() {
        completionText.setFill(Color.RED);
        completionText.setEffect(dropShadow);
        completionText.setCache(true);
        completionText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 80));
        completionText.setLayoutX(250);
        completionText.setLayoutY(375);
        completionText.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(completionText);
    }

    /**
     * show the error message when you want to get a hint but
     * your placement can not reach complement.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void showerror(){
        erroText.toFront();
        erroText.setOpacity(1);
    }

    /**
     * Create the message to be displayed when the player completes the puzzle.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeErromessage() {
        erroText.setFill(Color.RED);
        erroText.setEffect(dropShadow);
        erroText.setCache(true);
        erroText.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 40));
        erroText.setLayoutX(150);
        erroText.setLayoutY(375);
        erroText.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(erroText);
    }


    /**
     * Hide the completion message
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void hideCompletion() {
        completionText.toBack();
        completionText.setOpacity(0);
    }

    /**
     * hide the error message
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void hideError(){
        erroText.toBack();
        erroText.setOpacity(0);
    }

    /**
     * Set up event handlers for the main game
     *
     * @param scene The Scene used by the game.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void setUpHandlers(Scene scene) {
        /* create handlers for key press and release events */
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SLASH) {

                    makeHint();
                event.consume();
            }
            if (event.getCode()==KeyCode.M){
                toggleSoundLoop();
                event.consume();
            }
        });
        scene.setOnMouseClicked(event -> {
                hideError();
                event.consume();

        });
//        scene.setOnKeyPressed(event -> {
//
//        });

    }

    /**
     * Start a new game, resetting everything as necessary
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void newGame() {
        for (Pieces d:PS){
               d.draggable=true;
        }
        try{
            hideError();
            hideCompletion();
            pegs.getChildren().clear();
            Random random =new Random();
            //find a suitable start placement.
            int d = random.nextInt(Objective.difficulities1.length);
            int difficulity = (int) difficulty.getValue();
            this.difficulity=difficulity;
            number=d;
            String dd = "";
            String pg="";
            List<Character> ll = new ArrayList<>();

            //depending on the difficulties make a start placement.
            if (difficulity==1){
                resetPieces();
                dd= Objective.difficulities1[d];
                for (int i =0;i<dd.length();i=i+4){
                    String place = dd.substring(i,i+4);
                    if (place.charAt(0)>'h'){
                        pg=pg+place;
                        
                    }                else {
                        ll.add(place.charAt(0)); 
                    }
                }
                makePegs(pg);
                placePieces(dd);
            }else if (difficulity==2){
                resetPieces();
                dd= Objective.difficulities2[d];
                for (int i =0;i<dd.length();i=i+4){
                    String place = dd.substring(i,i+4);
                    if (place.charAt(0)>'h'){
                        pg=pg+place;

                    }                 else {
                        ll.add(place.charAt(0));
                    }
                }
                makePegs(pg);
                placePieces(dd);
            }else if (difficulity==3){
                resetPieces();
                dd= Objective.difficulities3[d];
                for (int i =0;i<dd.length();i=i+4){
                    String place = dd.substring(i,i+4);
                    if (place.charAt(0)>'h'){
                        pg=pg+place;

                    }else {
                        ll.add(place.charAt(0));
                    }
                }
                makePegs(pg);
                placePieces(dd);
            }
            else {
                resetPieces();
                dd= Objective.difficulities4[d];
                for (int i =0;i<dd.length();i=i+4){
                    String place = dd.substring(i,i+4);
                    if (place.charAt(0)>'h'){
                        pg=pg+place;

                    }else {
                      ll.add(place.charAt(0));
                    }
                }
                makePegs(pg);
                placePieces(dd);
            }
            for (Character c :ll){
                int number = c-'a';
                PS[number].draggable=false;
            }
            PEG = pg;
        }catch (IllegalArgumentException e){
            System.err.println("Uh oh. " + e);
            e.printStackTrace();
            Platform.exit();
        }
    }

    /**
     * show users how to play this game.
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void makeInstructor(){
        ImageView baseboard = new ImageView();
        baseboard.setImage(new Image(INSTRUCROr));
        baseboard.setFitWidth(150);
        baseboard.setFitHeight(200);
        baseboard.setLayoutX(280);
        baseboard.setLayoutY(500);
        backGround.getChildren().add(baseboard);
    }

    /**
     * Put all of the tiles back in their home position
     * @author Siyu Jiang u6563175@anu.edu.au
     */
    private void resetPieces() {
        pieces.toFront();
        for (Node n : pieces.getChildren()) {
            ((draggablePieces) n).snapToHome();
        }
    }

    // FIXME Task 7: Implement a basic playable Twist Game in JavaFX that only allows pieces to be placed in valid places

    // FIXME Task 8: Implement starting placements

    // FIXME Task 10: Implement hints

    // FIXME Task 11: Generate interesting starting placements

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("Start");
        b1.setTranslateX(420);
        b1.setTranslateY(280);
        b1.setScaleX(2); b1.setScaleY(2);
        primaryStage.setTitle("IQ Twist");

        root.getChildren().add(backGround);
        root.getChildren().add(board);
        root.getChildren().add(pieces);
        root.getChildren().add(pegs);
        root.getChildren().add(new Rectangular(0,0,30));

        root.getChildren().add(control);


     //  Scene scene1 = new Scene(backGround,BOARD_WIDTH,BOARD_HEIGHT);



        makeTitle();
        Label l1 = new Label("IQ TWIST");
        l1.setTranslateX(150);
        l1.setTranslateY(150);
        l1.setFont(Font.font("Apple Chancery", FontWeight.EXTRA_BOLD, 120));
        VBox layout1 = new VBox();
        layout1.getChildren().addAll(l1, b1);
        title.getChildren().add(layout1);
        Scene scene1 = new Scene(title, BOARD_WIDTH, BOARD_HEIGHT);
        Scene scene = new Scene(root,BOARD_WIDTH,BOARD_HEIGHT);
        setUpHandlers(scene);
        makeBackGround();
        makeInstructor();
        makeBoard();
        makePieces();
        makeControls();
        makeCompletion();
        makeErromessage();
        setUpSoundLoop();

        newGame();
        b1.setOnAction(event -> {
            primaryStage.setScene(scene);
        });

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
}
