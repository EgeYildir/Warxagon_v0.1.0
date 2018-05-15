package gui;

import engine.GameEngine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Map map = new Map();
        GameEngine gm = new GameEngine(map.getGrid(),1);
        primaryStage.setScene(new Scene(map));
        primaryStage.show();
    }
}
