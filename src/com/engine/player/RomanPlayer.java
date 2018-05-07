package engine.player;

import gui.Tile;
import units.buildings.Building;
import units.buildings.roman.*;

public class RomanPlayer extends Player {


    public RomanPlayer(Tile start) { // takes starting position as input
        this.getBul().add(new RomanTownHall(start));
        new Thread(this).start();
    }


    @Override
    public void buildMine(Tile t) {
        RomanMine b = new RomanMine(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void buildFarm(Tile t) {
        RomanFarm b = new RomanFarm(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void buildSawmill(Tile t) {
        RomanSawMills b = new RomanSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void buildBarracks(Tile t) {
        RomanBarracks b = new RomanBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void buildStonewall(Tile t) {
        RomanStoneWall b = new RomanStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void createInfantry() {

    }


    @Override
    public void run() { //increments resources after waiting for a preset time
        while (true) {
            this.setFood(this.getFood() + RomanFarm.getProductionPerCycle());
            this.setWood(this.getWood() + RomanFarm.getProductionPerCycle());
            this.setIron(this.getIron() + RomanMine.getProductionPerCycle());
            try {
                sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException ignored) {
            }
        }

    }
}
