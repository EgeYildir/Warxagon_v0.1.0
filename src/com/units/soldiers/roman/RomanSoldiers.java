package com.units.soldiers.roman;

import com.units.soldiers.Soldier;

public abstract class RomanSoldiers extends Soldier {
    int healthPower,attackPower,defensePower,goldCost,ironCost,woodCost;

    public RomanSoldiers(int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost) {
        super(healthPower, attackPower, defensePower, goldCost, woodCost, ironCost);
    }
}
