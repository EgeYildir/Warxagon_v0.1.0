package com.units.buildings.hun;

import com.grid.Tile;
import com.units.buildings.Building;
import com.engine.player.HunPlayer;

public class HunTownHall extends Building {// implements Runnable {
    private int workercount;
    private int level;

    public HunTownHall(Tile t) {
        super(t,1000,300,300,300);
        this.workercount = 10;
        this.level = 0;
        // new Thread(this).start();

    }
    public void levelUp() {
        this.level++;
        this.workercount = this.workercount +50; //to be developed

        // When it levels up health power will be increased. Players resources will be decremented for each level. Costs will be increased by its level.
        //Workers also will be incremented.
    }







































    /** @Override //If we wish to add building times or repairs in the future we will use this.
    public void run() {
    //repair and building goes here
    }*/
}
