package units.buildings.roman;

import GUI.Tile;
import units.buildings.Building;

public class RomanMine extends Building {

    private int level;
    private int iron;
    private static int productionPerCycle = 100;    public RomanMine(Tile t) {
        super(t,1000,200,300,100);

    }
    public static int getProductionPerCycle() {
        return productionPerCycle;
    }
}

