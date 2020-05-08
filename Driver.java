import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.geometry.*;

/*
Nathan Easterling
CSCI 136 Final Project
T shirt designer, exports images of T shirts
5/6/2020
 */

public class Driver extends Application {
    public static void main (String[] args) {
        launch(args);
    }
    private BorderPane bPane;
    private StackPane sPane;

    @Override
    public void start (Stage primaryStage) {

        bPane = new BorderPane();//Primary pane for organizing each
        sPane = new StackPane();//Pane for stacking images

        primaryStage.setTitle("T Shirt Designer");//title
        //Tshirt logos for buttons
        Image swhiteTee = new Image(getClass().getResourceAsStream("wTee.png"));
        Image sRedTee = new Image(getClass().getResourceAsStream("rTee.png"));
        Image sBlueTee = new Image(getClass().getResourceAsStream("bTee.png"));
        Image sGreenTee = new Image(getClass().getResourceAsStream("grTee.png"));
        Image sGreyTee = new Image(getClass().getResourceAsStream("gTee.png"));
        //Actual T shirt images.
        Image WhiteTee = new Image(getClass().getResourceAsStream("white_shirt.png"));
        Image RedTee = new Image(getClass().getResourceAsStream("red_shirt.png"));
        Image BlueTee = new Image(getClass().getResourceAsStream("blue_shirt.png"));
        Image GreenTee = new Image(getClass().getResourceAsStream("green_shirt.png"));
        Image GreyTee = new Image(getClass().getResourceAsStream("grey_shirt.png"));
        //Small logos for buttons
        Image sflames_logo = new Image(getClass().getResourceAsStream("s_flames.png"));
        Image snasa_logo = new Image(getClass().getResourceAsStream("s_nasa.png"));
        Image sguitar_logo = new Image(getClass().getResourceAsStream("s_guitar.png"));
        //Actual logo images
        Image flames_logo = new Image(getClass().getResourceAsStream("flames.png"));
        Image nasa_logo = new Image(getClass().getResourceAsStream("nasa.png"));
        Image guitar_logo = new Image(getClass().getResourceAsStream("guitar.png"));

        //Grids organize the bPane's sections into usable areas.
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridCenter = new GridPane();
        gridCenter.setAlignment(Pos.CENTER);
        gridCenter.setHgap(10);
        gridCenter.setVgap(10);
        gridCenter.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridRight = new GridPane();
        gridRight.setAlignment(Pos.TOP_RIGHT);
        gridRight.setHgap(10);
        gridRight.setVgap(10);
        gridRight.setPadding(new Insets(25, 25, 25, 25));

        GridPane gridBottom = new GridPane();
        gridBottom.setAlignment(Pos.BOTTOM_CENTER);
        gridBottom.setHgap(10);
        gridBottom.setVgap(10);
        gridBottom.setPadding(new Insets(25, 25, 25, 25));
        //sets the grids into bPane, also sPane for stacking images.
        bPane.setLeft(grid);
        bPane.setRight(gridRight);
        bPane.setCenter(sPane);
        bPane.setBottom(gridBottom);
        //starts the application window.
        Scene window = new Scene(bPane, 1000, 800);
        primaryStage.setScene(window);
        primaryStage.show();
        //Buttons
        Button wTee = new Button("White T");
        wTee.setGraphic(new ImageView(swhiteTee));
        grid.add(wTee,0,0);

        Button bTee = new Button("Blue T");
        bTee.setGraphic(new ImageView(sBlueTee));
        grid.add(bTee,0,1);

        Button rTee = new Button("Red T");
        rTee.setGraphic(new ImageView(sRedTee));
        grid.add(rTee,0,2);

        Button grTee = new Button("Grey T");
        grTee.setGraphic(new ImageView(sGreenTee));
        grid.add(grTee,0,3);

        Button gTee = new Button("Green T");
        gTee.setGraphic(new ImageView(sGreyTee));
        grid.add(gTee,0,4);

        Button nasa = new Button("Nasa Logo");
        nasa.setGraphic(new ImageView(snasa_logo));
        gridRight.add(nasa,0,2);

        Button fire = new Button("Flames Logo");
        fire.setGraphic(new ImageView(sflames_logo));
        gridRight.add(fire,0,3);

        Button guitar = new Button("Guitar Logo");
        guitar.setGraphic(new ImageView(sguitar_logo));
        gridRight.add(guitar,0,4);


        //Save button, runs function saveToFile in Functions.java
        Button saveBtn = new Button("Save Image");
        gridBottom.add(saveBtn,0,0);
        saveBtn.setOnAction(e -> Functions.saveToFile());

        //displayShirt and displayLogo are changable variables for storing the images we imported above.
        ImageView displayShirt = new ImageView();
        ImageView displayLogo = new ImageView();


        sPane.getChildren().addAll(displayShirt,displayLogo);//This created a layering effect so logos would appear above the shirts.

        //This is where most buttons are handled. All they do is change the displayShirt or displayLogo to the buttons type.
        wTee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayShirt.setImage(WhiteTee);
            }
        });
        bTee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayShirt.setImage(BlueTee);
            }
        });
        gTee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayShirt.setImage(GreenTee);
            }
        });
        rTee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayShirt.setImage(RedTee);
            }
        });grTee.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayShirt.setImage(GreyTee);
            }
        });
        //LOGO
        fire.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayLogo.setImage(flames_logo);
            }
        });nasa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayLogo.setImage(nasa_logo);
            }
        });guitar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                displayLogo.setImage(guitar_logo);
            }
        });
    }//End Stage
}