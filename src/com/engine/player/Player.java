package engine.player;



import units.buildings.Building;
import units.soldiers.Soldier;


import java.util.ArrayList;

public abstract class Player implements Playable {
    private int gold;
    private int iron;
    private int wood;
    private int food;
    private ArrayList<Soldier> sol;
    private ArrayList<Building> bul;

    public Player() {
        this.gold=5000;
        this.iron=5000;
        this.wood=5000;
        this.food=5000;
    }
    public synchronized int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public synchronized int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public synchronized int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public synchronized int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public ArrayList<Soldier> getSol() {
        return sol;
    }

    public void setSol(ArrayList<Soldier> sol) {
        this.sol = sol;
    }

    public synchronized ArrayList<Building> getBul() {
        return bul;
    }

    public void setBul(ArrayList<Building> bul) {
        this.bul = bul;
    }
}
