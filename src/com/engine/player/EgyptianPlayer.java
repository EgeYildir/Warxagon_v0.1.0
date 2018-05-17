package engine.player;

import gui.Grid;
import gui.Tile;
import javafx.scene.control.Button;
import units.buildings.Building;
import units.buildings.egyptian.*;
import units.buildings.roman.RomanBarracks;
import units.buildings.roman.RomanTownHall;
import units.soldiers.EgyptianInfantry;
import units.soldiers.RomanInfantry;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

public class EgyptianPlayer extends Player{


    public EgyptianPlayer(Tile start) {
        this.getBul().add(new RomanTownHall(start));
        this.start();

    }


    @Override
    public void buildMine(Tile t) {
        EgyptianMine b = new EgyptianMine(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.mines++;
    }

    @Override
    public void buildFarm(Tile t) {
        EgyptianFarm b = new EgyptianFarm(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.farms++;
    }

    @Override
    public void buildSawmill(Tile t) {
        EgyptianSawMills b = new EgyptianSawMills(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.sawmills++;
    }

    @Override
    public void buildBarracks(Tile t) {
        EgyptianBarracks b = new EgyptianBarracks(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
        this.barracks.add(b);
    }

    @Override
    public void buildStonewall(Tile t) {
        EgyptianStoneWall b = new EgyptianStoneWall(t);
        this.getBul().add(b);
        t.setB(b);
        this.setIron(this.getIron() - 200);
        this.setWood(this.getFood() - 200);
        this.setFood(this.getFood() - 200);
    }


    @Override
    public void createInfantry(Building b, Grid g) {
        if (b instanceof EgyptianBarracks || this.barracks.contains(b)) {
            List<Tile> spawnLocations = g.getNeighbors(b.getT());
            for (int i = 0;i<6;i++) {
                if (spawnLocations.get(i).isPassable()) {
                    ArrayList<Soldier> temp = new ArrayList<>();
                    for (int x =0;x<5;x++) {
                        temp.add(new EgyptianInfantry(spawnLocations.get(i)));
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
            this.setFood(this.getFood() + this.farms * EgyptianFarm.getProductionPerCycle());
            this.setWood(this.getWood() + this.sawmills*EgyptianSawMills.getProductionPerCycle());
            this.setIron(this.getIron() + this.mines*EgyptianMine.getProductionPerCycle());
            try {
                sleep(10000); //how long it will wait before incrementing again
            } catch (InterruptedException ignored) {
            }
        }
    }
}
