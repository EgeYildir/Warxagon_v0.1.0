package engine.player;


import units.buildings.Building;
import units.soldiers.Soldier;

import java.util.ArrayList;

public abstract class Player extends Thread implements Playable {
    private int iron;
    private int wood;
    private int food;
    int sawmills,mines,farms;
    ArrayList<Soldier> sol;
    ArrayList<Building> bul;
    ArrayList<Building> barracks;

    public Player() {
        this.iron = 5000;
        this.wood = 5000;
        this.food = 5000;
        this.bul = new ArrayList<Building>();
        this.sol = new ArrayList<Soldier>();
        this.barracks = new ArrayList<Building>();

    }

    public synchronized int getIron() {
        return iron;
    }

    public synchronized void setIron(int iron) {
        this.iron = iron;
    }

    public synchronized int getWood() {
        return wood;
    }

    public synchronized void setWood(int wood) {
        this.wood = wood;
    }

    public synchronized int getFood() {
        return food;
    }

    public synchronized void setFood(int food) {
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
