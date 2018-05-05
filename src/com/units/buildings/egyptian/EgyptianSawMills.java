package units.buildings.egyptian;

import GUI.Tile;
import units.buildings.Building;

public class EgyptianSawMills extends Building {

    private int level;
    private int wood;
    private static int productionPerCycle = 100;

    public EgyptianSawMills(Tile t) {
        super(t,1000,300,200,100);


    }
    public static int getProductionPerCycle() {
        return productionPerCycle;
    }
}
