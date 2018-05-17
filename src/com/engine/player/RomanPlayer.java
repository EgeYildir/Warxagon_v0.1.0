package engine.player;

import gui.Grid;
import gui.Tile;
import units.buildings.Building;
import units.buildings.roman.*;
import units.soldiers.RomanInfantry;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

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
        this.mines++;
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
        this.farms++;
    }

    @Override
    public void buildSawmill(Tile t) {
        RomanSawMills b = new RomanSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.sawmills++;
    }

    @Override
    public void buildBarracks(Tile t) {
        RomanBarracks b = new RomanBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.barracks.add(b);
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
    public void createInfantry(Building b, Grid g) {
        if (b instanceof RomanBarracks || this.barracks.contains(b)) {
            List<Tile> spawnLocations = g.getNeighbors(b.getT());
            for (int i = 0;i<6;i++) {
                if (spawnLocations.get(i).isPassable()) {
                    ArrayList<Soldier> temp = new ArrayList<>();
                    for (int x =0;x<5;x++) {
                        temp.add(new RomanInfantry(spawnLocations.get(i)));
                    }
                    spawnLocations.get(i).setSols(temp);
                    break;
                    }
                }
            }
        }



    @Override
    public void run() { //increments resources after waiting for a preset time
        while (true) {
            this.setFood(this.getFood() + this.farms*  RomanFarm.getProductionPerCycle());
            this.setWood(this.getWood() + this.sawmills *  RomanFarm.getProductionPerCycle());
            this.setIron(this.getIron() + this.mines* RomanMine.getProductionPerCycle());
            try {
                sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException ignored) {
            }
        }

    }
}
