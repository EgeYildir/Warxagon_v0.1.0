package com.units.buildings.roman;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.RomanPlayer;

public class RomanBuildings extends Building {

    public RomanBuildings(Tile t, int healthPower, int woodCost, int ironCost, int foodCost) {
        super(t,healthPower, woodCost, ironCost, foodCost);

    }

    @Override
    public void build() {

    }
}
