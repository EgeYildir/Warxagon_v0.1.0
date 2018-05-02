package com.units.soldiers.hun;

import com.units.soldiers.Soldier;

public abstract class HunSoldiers extends Soldier {


    public HunSoldiers(int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost) {
        super(healthPower, attackPower, defensePower, goldCost, woodCost, ironCost);
    }
}
