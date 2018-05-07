package engine.player;

import engine.Path;
import gui.Grid;
import gui.Tile;
import units.buildings.Building;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

public interface Playable {     //This interface will hold vital gameplay commands that both player and ai can access easily.
    default boolean checkWinConditions() { //Used to check if a player meets winning conditions.
        return true;
    }

    default void moveSoldier(Tile init, Tile target,Grid g) {
        List<Soldier> s = init.getSoldiers();
        Path p =new Path(s.get(0).currentTile(),target,g);
        for (Soldier sol:s) {
            sol.interrupt();
            sol.move(p.getPath());
        }
    }

    void buildMine(Tile t);

    void buildFarm(Tile t);

    void buildSawmill(Tile t);

    void buildBarracks(Tile t);

    void buildStonewall(Tile t);


    void createInfantry();
}
