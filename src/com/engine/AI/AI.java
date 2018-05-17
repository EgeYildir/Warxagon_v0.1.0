package engine.AI;

import engine.GameEngine;
import engine.Path;
import engine.StaticClasses.AIPlayer;
import engine.player.Playable;
import engine.player.Player;
import gui.Grid;
import gui.Tile;
import units.buildings.egyptian.EgyptianFarm;
import units.buildings.hun.HunBarracks;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.List;

public class AI {
    private Player player;
    private boolean weGotAttacked;


    public AI(Player p){
        this.player = p;
        this.weGotAttacked = false;
    }

    public void work(Grid grid){
        weGotAttacked = damageController();
        if(weGotAttacked || (player.getSol().size() > 20)){
            moveSoldier(AIPlayer.sol.get((int) (Math.random() * AIPlayer.sol.size())).currentTile(), engine.StaticClasses.Player.sol.get((int) (Math.random() * engine.StaticClasses.Player.sol.size())).currentTile(),grid);
        }else{
            build(grid.getAllNeighbors().get((int)(grid.getAllNeighbors().size()* Math.random())));
        }
    }



    public  void build(Tile tile){
        tile.setB(new HunBarracks(tile));
        tile.getB().getImage().setTranslateX(tile.getTranslateX());
        AIPlayer.addToMap(tile.getB().getImage());
        tile.getB().getImage().setTranslateY(tile.getTranslateY() - 40);
    }

    public void moveSoldier(Tile init, Tile target,Grid g) {
        List<Soldier> s = init.getSoldiers();
        Path p =new Path(s.get(0).currentTile(),target,g);
        for (Soldier sol:s) {
            sol.interrupt();
            sol.move(p.getPath());
        }
    }

    public boolean damageController(){
        for(int i = 0;i<AIPlayer.bul.size();i++){
            if(AIPlayer.bul.get(i).getHealthPower()<1000)return true;
        }
        return false;
    }
}
