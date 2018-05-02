package com.units.buildings.egyptian;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.EgyptianPlayer;

public class EgyptianBuildings extends Building {

    public EgyptianBuildings(Tile t, int healthPower, int woodCost, int ironCost, int foodCost) {
        super(t,healthPower, woodCost, ironCost, foodCost);
    }

    @Override
    public void build() {

    }
}
