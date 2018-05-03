package engine.player;

import GUI.Tile;

import units.buildings.Building;

public interface Playable {     //This interface will hold vital gameplay commands that both player and ai can access easily.
    default boolean checkWinConditions() { //Used to check if a player meets winning conditions.
        return true;
    }

    void buildMine(Tile t);

    void buildFarm(Tile t);

    void buildSawmill(Tile t);

    void buildBarracks(Tile t);

    void buildStonewall(Tile t);

    void levelUp(Building b);

    void createInfantry();
}
