package engine.player;

import GUI.Tile;
import units.buildings.Building;


import java.util.ArrayList;

public class RomanPlayer extends Player {


    public RomanPlayer(){

    }


    @Override
    public void buildMine(Tile t) {
<<<<<<< HEAD

=======
        RomanMine b = new RomanMine(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
    }

    @Override
    public void buildFarm(Tile t) {
<<<<<<< HEAD

=======
        RomanFarm b = new RomanFarm(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
    }

    @Override
    public void buildSawmill(Tile t) {
<<<<<<< HEAD

=======
        RomanSawMills b = new RomanSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
    }

    @Override
    public void buildBarracks(Tile t) {
<<<<<<< HEAD

=======
        RomanBarracks b = new RomanBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
    }

    @Override
    public void buildStonewall(Tile t) {
<<<<<<< HEAD

=======
        RomanStoneWall b = new RomanStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
    }

    @Override
    public void createInfantry() {

    }

    @Override
    public void levelUp(Building b) {

    }
<<<<<<< HEAD
=======

    @Override
    public void run() { //increments resources after waiting for a preset time
        while (true) {
            this.setFood(this.getFood() +RomanFarm.getProductionPerCycle());
            this.setWood(this.getWood() +RomanFarm.getProductionPerCycle());
            this.setIron(this.getIron() +RomanMine.getProductionPerCycle());
        try {
            currentThread().sleep(10000); //how long it will wait before incrementing again
        } catch (InterruptedException e) {
            continue;
        }
        }

    }
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
}
