package units.soldiers;

import gui.Map;
import gui.Tile;
import javafx.scene.image.ImageView;

import java.util.Stack;

public abstract class Soldier implements Runnable {

    private int healthPower;

    private int attackPower;

    private int defensePower;

    private int goldCost;

    private int woodCost;

    private int ironCost;

    private Thread currentAssault;

    public boolean isDead;

    public Map map;

    public int iIndex;

    public int jIndex;
    private Stack<Tile> path;

    public void move(Stack<Tile> a) {
        this.path =  a;
        currentAssault.start();
    }

    public abstract Tile currentTile();

    public abstract int getI();

    public abstract int getJ();

    public abstract void battle();

    public Soldier(int iIndex, int jIndex, int healthPower, int attackPower, int defensePower) {
        this.healthPower = healthPower;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.iIndex = iIndex;
        this.jIndex = jIndex;
        this.path = null;
        this.currentAssault = new Thread();
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

    public synchronized Stack<Tile> getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Soldiers HP:" + healthPower + " Soldiers Attack Power:" + attackPower + " Soldiers Defense Power:" + defensePower;
    }
    public void interrupt() {
        currentAssault.stop();
    }
    @Override
    public void run() {
        try {
            while (!(this.getPath().empty())) {
                this.currentTile().removeSol(this);
                this.getPath().pop().setSols(this);
                Thread.sleep(1000);
            }
        }   catch (InterruptedException ignored) {

        }

    }
}

