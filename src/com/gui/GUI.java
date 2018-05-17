package gui;

import engine.GameEngine;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import units.soldiers.HunInfantry;
import units.soldiers.Soldier;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GUI extends Application {
    public static void main(String[] args) {launch(args);}
    /*
    *   0:Egyptian
    *   1:Huns
    *   2:Roman
    */
    int factor;
    Stage window;
    private Scene gameScene;
    private Map map = new Map();
    private Group mainPane=new Group();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Map map = new Map();
        window= primaryStage;

        primaryStage.setScene(mainMenu());
        primaryStage.show();


    }

    private Scene mainMenu() throws FileNotFoundException {
        StackPane mainMenu = new StackPane();

        Label header = new Label("WARXAGON");
        header.setStyle("-fx-min-width:600px;" +
                "-fx-min-height: 400px;" +
                "-fx-font-size:144px;" +
                "-fx-font-weight:bolder;" +
                "-fx-text-align:center;" +
                "");
        header.setTranslateY(-150);
        Button hun = new Button("HUNS"),
               egyptian = new Button("EGYPTIANS"),
               roman = new Button("ROMANS"),
               play= new Button("PLAY GAME");

       hun.setTranslateX(-220);hun.setTranslateY(50);
        egyptian.setTranslateX(0);egyptian.setTranslateY(50);
        roman.setTranslateX(220);roman.setTranslateY(50);
        play.setTranslateX(0);play.setTranslateY(200);

        String style =
                "-fx-text-color:aqua;" +
                "-fx-padding:15px;" +
                "-fx-font-weight:bolder;" +
                "-fx-background-color : blue;" +
                "-fx-min-width:150px;" +
                "-fx-min-height:50px;" +
                "-fx-border-width:5px;" +
                "-fx-border-color:aqua;" +
                "-fx-border-radius:17px;"  +
                "-fx-background-radius:17px;" +
                "-fx-font-size: 24px;";

        hun.setStyle(style);roman.setStyle(style);egyptian.setStyle(style);play.setStyle(style);

        mainMenu.getChildren().add(header);
        mainMenu.getChildren().add(play);
        mainMenu.getChildren().add(hun);
        mainMenu.getChildren().add(roman);
        mainMenu.getChildren().add(egyptian);

        hun.setOnAction(e -> factor=1);
        roman.setOnAction(e -> factor=2);
        egyptian.setOnAction(e -> factor=0);

        play.setOnAction(e -> startGame());



        Scene scene = new Scene(mainMenu,1200,720);
        scene.getStylesheets().add(GUI.class.getResource("menu.css").toExternalForm());
        return scene;

    }
    private void startGame(){
        mainPane.getChildren().add(map);
        bar();
        GameEngine gameEngine = new GameEngine(map.getGrid(),factor);
        gameScene = new Scene(mainPane);
        window.setScene(gameScene);
        window.setFullScreen(true);
    }

    private void preLoad(){

    }

    private void update(){

    }


    private void bar(){
        Group bar = new Group();
        bar.minWidth(Screen.getPrimary().getVisualBounds().getWidth());
        bar.minHeight(100);
        bar.setTranslateY(Screen.getPrimary().getVisualBounds().getHeight()-100);
        bar.setStyle("-fx-background-color:brown;");

        Button addBuild = new Button("ADD BUILDING");
        addBuild.setMinSize(200,50);
        addBuild.setTranslateX(125);addBuild.setTranslateY(25);

        addBuild.setOnAction(event -> CHECK.buildingcheck.selected=true);



        bar.getChildren().add(addBuild);
        mainPane.getChildren().add(bar);

    }









}
