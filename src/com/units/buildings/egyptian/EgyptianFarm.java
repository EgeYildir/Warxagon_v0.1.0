package units.buildings.egyptian;


import gui.Tile;
import units.buildings.Building;

public class EgyptianFarm extends Building {

    private int level;
    private int food;
    private static int productionPerCycle = 100;

    public EgyptianFarm(Tile t) {
        super(t,1000,200,100,300);
    }

    public static int getProductionPerCycle() {
        return productionPerCycle;
    }
}

