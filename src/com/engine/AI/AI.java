package engine.AI;

import engine.player.Player;
import gui.Tile;

import java.util.ArrayList;

public class AI {
    private Player player;
    private ArrayList<Build> buildingList;
    private boolean weGotAttacked;


    public AI(Player p){
        this.player = p;
        this.buildingList = new ArrayList<>();
        this.weGotAttacked = false;

    }

    public void work(){
        if(weGotAttacked || (player.getSol().size() > 20)){
            attack();
        }else{
            buildingList.get(0);
        }
    }

    public void attack(){

    }


}
