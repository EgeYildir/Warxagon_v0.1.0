package units.buildings.egyptian;


import GUI.Tile;
import units.buildings.Building;

public class EgyptianMine extends Building {

    private int level;
    private int iron;
    private static int productionPerCycle = 100;

    public EgyptianMine(Tile t) {
        super(t,1000,200,300,100);

    }
    public static int getProductionPerCycle() {
        return productionPerCycle;
    }

}

