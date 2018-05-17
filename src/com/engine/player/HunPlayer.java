package engine.player;

import gui.Grid;
import gui.Tile;
import units.buildings.Building;
import units.buildings.hun.*;
import units.buildings.roman.RomanTownHall;
import units.soldiers.HunInfantry;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

public class HunPlayer extends Player {


    public HunPlayer(Tile start) {
        this.getBul().add(new RomanTownHall(start));
        this.start();

    }


    @Override
    public void buildMine(Tile t) {
        HunMine b = new HunMine(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.mines++;
    }

    @Override
    public void buildFarm(Tile t) {
        HunFarm b = new HunFarm(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.farms++;
    }

    @Override
    public void buildSawmill(Tile t) {
        HunSawMills b = new HunSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.sawmills++;
    }

    @Override
    public void buildBarracks(Tile t) {
        HunBarracks b = new HunBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.barracks.add(b);
    }

    @Override
    public void buildStonewall(Tile t) {
        HunStoneWall b = new HunStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }

    @Override
    public void createInfantry(Building b, Grid g) {
        if (b instanceof HunBarracks || this.barracks.contains(b)) {
            List<Tile> spawnLocations = g.getNeighbors(b.getT());
            for (int i = 0;i<6;i++) {
                if (spawnLocations.get(i).isPassable()) {
                    ArrayList<Soldier> temp = new ArrayList<>();
                    for (int x =0;x<5;x++) {
                        temp.add(new HunInfantry(spawnLocations.get(i)));
                    }
                    spawnLocations.get(i).setSols(temp);
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            this.setFood(this.getFood() + this.farms*HunFarm.getProductionPerCycle());
            this.setWood(this.getWood() + this.sawmills*HunSawMills.getProductionPerCycle());
            this.setIron(this.getIron() + this.mines*HunMine.getProductionPerCycle());
            try {
                sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException ignored) {
            }
        }
    }
}
