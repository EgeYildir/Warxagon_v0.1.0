package com.engine;

import com.grid.Path;
import com.grid.Tile;
import com.main.Main;
import com.main.Map;
import com.units.soldiers.Soldier;
import com.units.soldiers.egyptian.EgyptianInfantry;
import com.units.soldiers.hun.HunInfantry;
import com.units.soldiers.roman.RomanInfantry;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    public static Map map;
    public static List<Soldier> soldiers = new ArrayList<>();
    public static List<Tile> current = new ArrayList<>();

    public GameEngine() {
        map = new Map(20, 20);


        Soldier rm = new RomanInfantry(map, 2, 2, 1000, 225, 150, 100, 80, 200);
        Soldier em = new EgyptianInfantry(map, 2, 2, 1000, 150, 400, 100, 80, 200);
        soldiers.add(rm);
        soldiers.add(em);
        check();

    }

    public void start() {
        Main.window.setScene(map.getScene());
        Main.window.setFullScreen(true);
        Main.window.show();
    }

    private void check() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (current.size() > 0) {
                    if (!soldiers.get(0).isInPath()) {
                        Path path = new Path(soldiers.get(0).getI(), soldiers.get(0).getJ(), current.get(0), map.getGrid().getGrid());
                        soldiers.get(0).move(path.getPath());
                        current.remove(0);
                    }
                }
            }
        }.start();
    }
}
