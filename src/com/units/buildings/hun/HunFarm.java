package units.buildings.hun;


import GUI.Tile;
import units.buildings.Building;

public class HunFarm extends Building {

    private int level;
    private int food;
    private static int productionPerCycle = 100;
    public HunFarm(Tile t) {
        super(t,1000,200,100,300);


    }

    public  static int getProductionPerCycle() {
        return productionPerCycle;
    }

}

