package engine;


import GUI.Grid;
import engine.player.EgyptianPlayer;
import engine.player.HunPlayer;
import engine.player.Player;
import engine.player.RomanPlayer;


import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private Player p1;
    private Player p2;
    private Grid grid;
    // private Ai ai;
    public GameEngine(Grid g,int selectedFaction) {
        this.p1 = selectPlayer(selectedFaction);
        this.p2 = selectPlayer();
        this.grid = g;
        //this.ai = new Ai(p2); // starts the ai that controls player2.





    }
    private Player selectPlayer(int s) {
        switch (s) {
            case 0:
                return new EgyptianPlayer();
            case 1:
                return new HunPlayer();
            case 2: return new RomanPlayer();
            default: return null;

        }
    }
    private Player selectPlayer() {
        int x = (int)(Math.random()*3);
        return selectPlayer(x);
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
}
