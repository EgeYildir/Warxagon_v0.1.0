package engine.player;

import GUI.Tile;
import engine.player.Player;
import units.buildings.Building;

import java.util.ArrayList;

public class HunPlayer extends Player {


    public HunPlayer(){

    }


    @Override
    public void buildMine(Tile t) {
<<<<<<< HEAD

=======
       HunMine b = new HunMine(t);
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
        HunFarm b = new HunFarm(t);
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
        HunSawMills b = new HunSawMills(t);
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
        HunBarracks b = new HunBarracks(t);
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
        HunStoneWall b = new HunStoneWall(t);
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
            this.setFood(this.getFood() + HunFarm.getProductionPerCycle());
            this.setWood(this.getWood() + HunSawMills.getProductionPerCycle());
            this.setIron(this.getIron()+ HunMine.getProductionPerCycle());
            try {
                currentThread().sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
>>>>>>> f8ab10149dc34d3670659fd99a14ef80ca92c3b7
}
