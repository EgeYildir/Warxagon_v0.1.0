package units.buildings.roman;


import GUI.Tile;
import units.buildings.Building;

public class RomanSawMills extends Building {

    private int level;
    private int wood;

    public RomanSawMills(Tile t) {
        super(t,1000,300,200,100);
        // new Thread(this).start();
    }

    // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
    //Produce wood method will be added and producing will be incremented by each level.
}
