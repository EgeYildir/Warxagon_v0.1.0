package units.soldiers;

import gui.Map;
import gui.Tile;
import javafx.scene.image.ImageView;

import java.util.Stack;


public class RomanInfantry extends Soldier {//Aynı zamanda bir soldier objesi olması game Enginedeki Arraylistlerde  bize kolaylık sağlıyor.

    private Tile currentTile;
    private int iIndex, jIndex;


    public RomanInfantry(Tile t) {
        super(t.getI(), t.getJ(), 1000, 100, 100);
    }



    @Override
    public Tile currentTile() {
        return currentTile;
    }


    @Override
    public int getI() {
        return iIndex;
    }

    @Override
    public int getJ() {
        return jIndex;
    }



    @Override
    public void battle() {
        if (currentTile.encounter() != 0) {
            currentTile.battle(currentTile.encounter());
        }
    }

    @Override
    public void run() {

    }
}
