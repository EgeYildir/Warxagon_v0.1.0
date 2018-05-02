package com.units.buildings.roman;

import com.grid.Tile;
import com.units.buildings.Building;

public class RomanFarm extends Building {

    private int level;
    private int food;

    public RomanFarm(Tile t) {
        super(t, 1000, 200, 100, 300);
        // new Thread(this).start();
    }

    // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //Produce food method will be added and producing will be incremented by each level.

}

