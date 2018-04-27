package com.units.buildings.egyptian;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.EgyptianPlayer;

public class EgyptianBarracks extends Building{

    private int level;

    public EgyptianBarracks(Tile t) {
        super(t,1000,400,400,400);
        // new Thread(this).start();
    }

    //When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //public Train method which returns arraylist of soldiers(10 soldiers) will be implemented it can be incremented by its level.

}
