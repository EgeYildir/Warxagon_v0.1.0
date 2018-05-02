package com.units.buildings.egyptian;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.EgyptianPlayer;

public class EgyptianFarm extends Building {

    private int level;
    private int food;

    public EgyptianFarm(Tile t) {
        super(t,1000,200,100,300);
        // new Thread(this).start();
    }

    // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //Produce food method will be added and producing will be incremented by each level.

}

