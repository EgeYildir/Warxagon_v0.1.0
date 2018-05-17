package engine.AI;

import engine.GameEngine;
import engine.StaticClasses.AIPlayer;
import engine.player.Player;
import gui.Grid;
import gui.Tile;
import units.buildings.egyptian.EgyptianFarm;
import units.buildings.hun.HunBarracks;

import java.util.ArrayList;

public class AI {
    private Player player;
    private boolean weGotAttacked;


    public AI(Player p){
        this.player = p;
        this.weGotAttacked = false;
    }

    public void work(Grid grid){
        if(weGotAttacked || (player.getSol().size() > 20)){
            attack();
        }else{
            build(grid.getNeighbors().get((int)(grid.getNeighbors().size()* Math.random())));
        }
    }

    public void attack(){

    }

    public  void build(Tile tile){
        tile.setB(new HunBarracks(tile));
        tile.getB().getImage().setTranslateX(tile.getTranslateX());
        AIPlayer.addToMap(tile.getB().getImage());
        tile.getB().getImage().setTranslateY(tile.getTranslateY() - 40);
    }

}
