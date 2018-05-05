package units.buildings.roman;


import GUI.Tile;
import units.buildings.Building;

public class RomanFarm extends Building {

    private int level;
    private int food;
    private static int productionPerCycle = 100;
    public RomanFarm(Tile t) {
        super(t,1000,200,100,300);

    }

    public static int getProductionPerCycle() {
        return productionPerCycle;
    }

}

