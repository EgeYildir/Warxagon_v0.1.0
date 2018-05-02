package com.engine.player;

import com.units.buildings.Building;
import com.units.soldiers.Soldier;

import java.util.ArrayList;

public abstract class Player implements Playable {      //An
    private int gold;
    private int iron;
    private int wood;
    private int food;
    private ArrayList<Soldier> sol;
    private ArrayList<Building> bul;
    private int sawmillcount;
    private int farmcount;
    private int minecount;

    public Player() {
        this.gold = 5000;
        this.iron = 5000;
        this.wood = 5000;
        this.food = 5000;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getFood() {
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

    public ArrayList<Building> getBul() {
        return bul;
    }

    public void setBul(ArrayList<Building> bul) {
        this.bul = bul;
    }
}
