package engine.player;

import GUI.Tile;
import units.buildings.Building;


import java.util.ArrayList;

public class EgyptianPlayer extends Player {


    public EgyptianPlayer() {

    }


    @Override
    public void buildMine(Tile t) {
<<<<<<< HEAD

=======
     EgyptianMine b = new EgyptianMine(t);
     this.getBul().add(b);
     t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
<<<<<<< HEAD
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
=======
>>>>>>> 8fc8d40ec59c0eeeb737d4be23374aff4bca04c1
    }

    @Override
    public void buildFarm(Tile t) {
<<<<<<< HEAD

=======
        EgyptianFarm b = new EgyptianFarm(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
<<<<<<< HEAD
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
=======
>>>>>>> 8fc8d40ec59c0eeeb737d4be23374aff4bca04c1
    }

    @Override
    public void buildSawmill(Tile t) {
<<<<<<< HEAD

=======
        EgyptianSawMills b = new EgyptianSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
<<<<<<< HEAD
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
=======
>>>>>>> 8fc8d40ec59c0eeeb737d4be23374aff4bca04c1
    }

    @Override
    public void buildBarracks(Tile t) {
<<<<<<< HEAD

=======
        EgyptianBarracks b = new EgyptianBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
<<<<<<< HEAD
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
=======
>>>>>>> 8fc8d40ec59c0eeeb737d4be23374aff4bca04c1
    }

    @Override
    public void buildStonewall(Tile t) {
<<<<<<< HEAD

=======
        EgyptianStoneWall b = new EgyptianStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron()-200);
        this.setWood(this.getFood()-200);
        this.setFood(this.getFood()-200);
<<<<<<< HEAD
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
=======
>>>>>>> 8fc8d40ec59c0eeeb737d4be23374aff4bca04c1
    }

    @Override
    public void levelUp(Building b) {

    }

    @Override
    public void createInfantry() {

    }
<<<<<<< HEAD
=======

    @Override
    public void run() {
        while (true) {
            this.setFood(this.getFood() + EgyptianFarm.getProductionPerCycle());
            this.setWood(this.getWood() +  EgyptianSawMills.getProductionPerCycle());
            this.setIron(this.getIron() + EgyptianMine.getProductionPerCycle());
            try {
                currentThread().sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
}
