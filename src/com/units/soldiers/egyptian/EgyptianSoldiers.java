package com.units.soldiers.egyptian;

import com.units.soldiers.Soldier;

public abstract class EgyptianSoldiers extends Soldier {
    public EgyptianSoldiers(int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost) {
        super(healthPower, attackPower, defensePower, goldCost, woodCost, ironCost);
    }
}
