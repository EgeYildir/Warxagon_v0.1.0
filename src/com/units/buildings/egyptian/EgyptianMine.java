package units.buildings.egyptian;


import GUI.Tile;
import units.buildings.Building;

public class EgyptianMine extends Building {

    private int level;
    private int iron;

    public EgyptianMine(Tile t) {
        super(t,1000,200,300,100);
        // new Thread(this).start();
    }

    // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //Produce iron method will be added and producing will be incremented by each level.

}

