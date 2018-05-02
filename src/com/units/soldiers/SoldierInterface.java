package com.units.soldiers;

import com.units.buildings.Building;

import java.util.List;

public interface SoldierInterface {

    default void move(Tile[] tiles) {
    }

    default int encounter() {
        boolean roman = false;
        boolean hun = false;
        boolean egyptian = false;

        List<Soldier> soldiers = this.getSoldiers();
        if (soldiers.size() > 1) {
            Iterator i = soldiers.iterator();
            while (i.hasNext()) {
                Soldier s = (Soldier) i.next();
                if (s instanceof RomanInfantry) {
                    roman = true;
                }
                if (s instanceof HunInfantry) {
                    hun = true;
                }
                if (s instanceof EgyptianInfantry) {
                    egyptian = true;

                }
            }
            if ((roman && hun)) {
                return 1;
            } else if (hun && egyptian) {
                return 2;
            } else if (roman && egyptian) {
                return 3;
            }
        }
        return 0;
    }

    default List<Soldier> getSoldiers() {
        return null;
    }

    default void battle(int i) {
    }

    default void battle(List<Soldier> s1, List<Soldier> s2) {
    }

    default void battle(Soldier s1, Soldier s2) {
    }

    default void attackBuilding(List<Soldier> s1, Building b) {
    }


}

