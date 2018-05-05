package units.buildings.hun;

import GUI.Tile;
import units.buildings.Building;

public class HunMine extends Building {

    private int level;
    private int iron;
    private static int productionPerCycle = 100;
    public HunMine(Tile t) {
        super(t,1000,200,300,100);
    }

    public static int getProductionPerCycle() {
        return productionPerCycle;
    }

}

