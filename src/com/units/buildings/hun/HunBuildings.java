package com.units.buildings.hun;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.HunPlayer;

public class HunBuildings extends Building {

    public HunBuildings(Tile t, int healthPower, int woodCost, int ironCost, int foodCost) {
        super(t,healthPower, woodCost, ironCost, foodCost);
    }

    @Override
    public void build() {

    }
}
