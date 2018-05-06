package units.soldiers;

import gui.Map;
import gui.Tile;
import javafx.scene.image.ImageView;

public abstract class Soldier {

    private int healthPower;

    private int attackPower;

    private int defensePower;

    private int goldCost;

    private int woodCost;

    private int ironCost;

    public boolean isDead;

    public Map map;

    public int iIndex;

    public int jIndex;

    public abstract ImageView getSource();

    public abstract void move(Tile[] a);

    public abstract Tile currentTile();

    public abstract int getI();

    public abstract int getJ();

    public abstract boolean isInPath();

    public abstract void setIsInPath(boolean a);

    public abstract void battle();

    public Soldier(Map map, int iIndex, int jIndex, int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost) {
        this.healthPower = healthPower;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.goldCost = goldCost;
        this.woodCost = woodCost;
        this.ironCost = ironCost;
        this.map = map;
        this.iIndex = iIndex;
        this.jIndex = jIndex;
    }

    public Soldier() {
    }


    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getGoldCost() {
        return goldCost;
    }

    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }

    public int getWoodCost() {
        return woodCost;
    }

    public void setWoodCost(int woodCost) {
        this.woodCost = woodCost;
    }

    public int getIronCost() {
        return ironCost;
    }

    public void setIronCost(int ironCost) {
        this.ironCost = ironCost;
    }


    @Override
    public String toString() {
        return "Soldiers HP:" + healthPower + " Soldiers Attack Power:" + attackPower + " Soldiers Defense Power:" + defensePower;
    }

}

