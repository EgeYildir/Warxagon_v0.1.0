package engine;


import engine.StaticClasses.AIPlayer;
import engine.player.EgyptianPlayer;
import engine.player.HunPlayer;
import engine.player.Player;
import engine.player.RomanPlayer;
import gui.Grid;
import gui.Map;
import units.soldiers.Soldier;

import java.util.List;

public class GameEngine {

    public static List<Soldier> soldiers;
    private Player p1;
    private Player p2;
    private Grid grid;

    // private Ai ai;
    public GameEngine(Map map, int selectedFaction) {
        this.grid = map.getGrid();
        this.p1 = selectPlayer(selectedFaction);
 //randomises the ai controlled player.
        AIPlayer.faction = (int)(Math.random() * 3);
        AIPlayer.map=map;
        //this.ai = new Ai(p2); // starts the ai that controls player2.
        this.p2 = selectPlayer();
    }

    private Player selectPlayer(int s) { //Initial start locations for each player needs to be determined in Grid class.
        switch (s) {
            case 0:
                return new EgyptianPlayer(this.grid.getStartLocation1());
            case 1:
                return new HunPlayer(this.grid.getStartLocation1());
            case 2:
                return new RomanPlayer(this.grid.getStartLocation1());
            default:
                return null;

        }
    }

    private Player selectPlayer() {
        int x = AIPlayer.faction;
        switch (x) {
            case 0:
                return new EgyptianPlayer(this.grid.getStartLocation2());
            case 1:
                return new HunPlayer(this.grid.getStartLocation2());
            case 2:
                return new RomanPlayer(this.grid.getStartLocation2());
            default:
                return null;
        }
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
}
