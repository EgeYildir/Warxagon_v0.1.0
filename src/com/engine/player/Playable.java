package com.engine.player;

import com.units.buildings.Building;

public interface Playable {     //This interface will hold vital gameplay commands that both player and ai can access easily.
    default boolean checkWinConditions() { //Used to check if a player meets winning conditions.
        return true;
    }

    void buildMine();

    void buildFarm();

    void buildSawmill();

    void buildBarracks();

    void buildStonewall();

    void levelUp(Building b);

    void createInfantry();
}
