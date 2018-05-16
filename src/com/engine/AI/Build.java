package engine.AI;

import engine.player.Player;
import gui.Tile;
import units.buildings.Building;

import java.util.ArrayList;
import java.util.Random;

public class Build {
    Random rnd = new Random();
    private Building toDo;
    private Tile tile;
    private ArrayList<Tile> buildingLocations;

    public Build(Building building, Player player){
        this.toDo = building;
        this.tile = buildingLocations.get(rnd.nextInt(buildingLocations.size()));
    }

    /*public ResourceType need(){
        if(woodIncrease < others)return WOOD;
        if(ironIncrease < others)return IRON;
        if(foodIncrease < others)return FOOD;
        if(soldierCount * aggro < buildingCount)return SOLDIER;
    }*/



}
