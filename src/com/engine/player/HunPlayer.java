package engine.player;

import GUI.Tile;
import engine.player.Player;
import units.buildings.Building;
import units.buildings.hun.*;
import units.buildings.roman.RomanTownHall;

import java.util.ArrayList;

public class HunPlayer extends Player {


    public HunPlayer(Tile start){
        this.getBul().add(new RomanTownHall(start));
        this.start();

    }


    @Override
    public void buildMine(Tile t) {
       HunMine b = new HunMine(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildFarm(Tile t) {
        HunFarm b = new HunFarm(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildSawmill(Tile t) {
        HunSawMills b = new HunSawMills(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildBarracks(Tile t) {
        HunBarracks b = new HunBarracks(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildStonewall(Tile t) {
        HunStoneWall b = new HunStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void levelUp(Building b) {

    }

    @Override
    public void createInfantry() {

    }

    @Override
    public void run() {
        while (true) {
            this.setFood(HunFarm.getProductionPerCycle());
            this.setWood(HunSawMills.getProductionPerCycle());
            this.setIron(HunMine.getProductionPerCycle());
            try {
                currentThread().sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
