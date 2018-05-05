package engine.player;

import GUI.Tile;
import units.buildings.Building;
import units.buildings.egyptian.EgyptianFarm;
import units.buildings.roman.*;


import java.util.ArrayList;

public class RomanPlayer extends Player {


    public RomanPlayer(Tile start){
        this.getBul().add(new RomanTownHall(start));
        this.start();
    }


    @Override
    public void buildMine(Tile t) {
        RomanMine b = new RomanMine(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildFarm(Tile t) {
        RomanFarm b = new RomanFarm(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildSawmill(Tile t) {
        RomanSawMills b = new RomanSawMills(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildBarracks(Tile t) {
        RomanBarracks b = new RomanBarracks(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildStonewall(Tile t) {
        RomanStoneWall b = new RomanStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void createInfantry() {

    }

    @Override
    public void levelUp(Building b) {

    }

    @Override
    public void run() { //increments resources after waiting for a preset time
        while (true) {
            this.setFood(RomanFarm.getProductionPerCycle());
            this.setWood(RomanFarm.getProductionPerCycle());
            this.setIron(RomanMine.getProductionPerCycle());
        try {
            currentThread().sleep(10000); //how long it will wait before incrementing again
        } catch (InterruptedException e) {
            continue;
        }
        }

    }
}
