package com.units.buildings.hun;

import com.grid.Tile;
import com.units.buildings.Building;

public class HunMine extends Building {

    private int level;
    private int iron;

    public HunMine(Tile t) {
        super(t, 1000, 200, 300, 100);
        // new Thread(this).start();
    }

    // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //Produce iron method will be added and producing will be incremented by each level.

}

