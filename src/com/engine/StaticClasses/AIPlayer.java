package engine.StaticClasses;

import gui.Map;
import javafx.scene.Node;
import units.buildings.Building;
import units.soldiers.Soldier;

import java.util.ArrayList;

public class AIPlayer {
    private static int faction;
    private static int iron;
    private static int wood;
    private static int food;

    static ArrayList<Soldier> sol;
    static ArrayList<Building> bul;
     static Map map;


    public static void addToMap(Node n){
        map.getChildren().add(n);
    }
}
