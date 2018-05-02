package com.units.buildings.egyptian;

import com.grid.Tile;
import com.units.buildings.Building;

public class EgyptianStoneWall extends Building {

    private int level;

    public EgyptianStoneWall(Tile t) {
        super(t, 1000, 0, 300, 0);
        // new Thread(this).start();

        // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    }


    /** @Override //If we wish to add building times or repairs in the future we will use this.
    public void run() {
    //repair and building goes here
    }*/
}
