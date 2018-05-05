package engine.player;

import GUI.Tile;
import units.buildings.Building;
import units.buildings.egyptian.*;
import units.buildings.roman.RomanTownHall;


import java.util.ArrayList;

public class EgyptianPlayer extends Player {


    public EgyptianPlayer(Tile start) {
        this.getBul().add(new RomanTownHall(start));
        this.start();

    }


    @Override
    public void buildMine(Tile t) {
     EgyptianMine b = new EgyptianMine(t);
     this.getBul().add(b);
     t.setB(b);

    }

    @Override
    public void buildFarm(Tile t) {
        EgyptianFarm b = new EgyptianFarm(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildSawmill(Tile t) {
        EgyptianSawMills b = new EgyptianSawMills(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildBarracks(Tile t) {
        EgyptianBarracks b = new EgyptianBarracks(t);
        this.getBul().add(b);
        t.setB(b);
    }

    @Override
    public void buildStonewall(Tile t) {
        EgyptianStoneWall b = new EgyptianStoneWall(t);
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
            this.setFood(EgyptianFarm.getProductionPerCycle());
            this.setWood(EgyptianSawMills.getProductionPerCycle());
            this.setIron(EgyptianMine.getProductionPerCycle());
            try {
                currentThread().sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
