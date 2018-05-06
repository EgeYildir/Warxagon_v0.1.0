package units.soldiers;

import gui.Map;
import gui.Tile;
import javafx.scene.image.ImageView;


public class EgyptianInfantry extends Soldier {//Aynı zamanda bir soldier objesi olması game Enginedeki Arraylistlerde  bize kolaylık sağlıyor.
    ImageView source;//asıl işlem yapılacak image.
    private double dmg;//Şu anlık kullanılmıyor.
    private double velIndex;
    private boolean isInPath;//Eğer bir yolda yürüyorsa başka bir pathe sapmasını engelleyen boolean.
    private Tile currentTile;
    private int iIndex, jIndex;

    public EgyptianInfantry(Map map, int iIndex, int jIndex, int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost) {
        super(map, iIndex, jIndex, healthPower, attackPower, defensePower, goldCost, woodCost, ironCost);
    }

    @Override
    public Tile currentTile() {
        return currentTile;
    }

    public ImageView getSource() {
        return source;
    }

    @Override
    public void move(Tile[] a) {

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
    public boolean isInPath() {
        return isInPath;
    }

    @Override
    public void setIsInPath(boolean a) {
        isInPath = a;
    }

    @Override
    public void battle() {
        if (currentTile.encounter() != 0) {
            currentTile.battle(currentTile.encounter());
        }
    }

}
