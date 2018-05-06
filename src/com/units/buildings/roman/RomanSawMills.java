package units.buildings.roman;


import gui.Tile;
import units.buildings.Building;

public class RomanSawMills extends Building {

    private int level;
    private int wood;
    private static int productionPerCycle = 100;    public RomanSawMills(Tile t) {
        super(t,1000,300,200,100);

    }
    public static int getProductionPerCycle() {
        return productionPerCycle;
    }
}
