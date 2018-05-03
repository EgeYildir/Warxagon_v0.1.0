package engine;

import GUI.Grid;
import GUI.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Path {
    private int initialX, initialY;
    private int targetX, targetY;
    private Grid grid;
    private Stack path;
    private ArrayList<Tile> frontier;
    private ArrayList<Tile> visited;
    private HashMap<Tile,Tile> t;


    public Path(Tile initialTile, Tile targetTile, Grid grid) {
        this.initialX = initialTile.getI();
        this.initialY = initialTile.getJ();
        this.targetX = targetTile.getI();
        this.targetY = targetTile.getJ();
        this.grid = grid;
        this.frontier = new ArrayList<Tile>();
        this.visited = new ArrayList<Tile>();
        this.t = new HashMap<Tile, Tile>();
        this.path = new Stack();
        createPath();

    }
    private void createPath() {
        this.getFrontier().add(this.getGrid().get(this.getInitialX(),this.getInitialY()));
        this.getVisited().add(this.getGrid().get(this.getInitialX(),this.getInitialY()));
        while (!(this.getFrontier().isEmpty())) {
            Tile current = this.getFrontier().get(0);
            this.getFrontier().remove(0);
            ArrayList<Tile> n = this.grid.getNeighbors(current);
            while (!(n.isEmpty())) {
                if (this.getVisited().contains(n.get(0))) {
                    n.remove(0);
                } else {
                    if (n.get(0).equals(this.getGrid().get(this.getTargetX(),this.getTargetY()))) {
                        this.getT().put(n.get(0), current);
                        break;
                    }
                    this.getVisited().add(n.get(0));
                    this.getFrontier().add(n.get(0));
                    this.getT().put(n.get(0), current);
                    n.remove(0);
                }
            }
        }
        this.getPath().push(this.getGrid().get(this.getTargetX(),this.getTargetY()));
        Tile temp = this.getGrid().get(this.getTargetX(),this.getTargetY());
        while (!(this.getGrid().get(this.getInitialX(),this.getInitialY()).equals(temp))) {
            this.getPath().add(this.getT().get(temp));
            temp = this.getT().get(temp);
        }
        this.getPath().pop();


    }
    private Grid getGrid() {
        return grid;
    }
 //needa additional methods to work
    private ArrayList<Tile> getFrontier() {
        return frontier;
    }
    private ArrayList<Tile> getVisited() {
        return visited;
    }
    private int getInitialX() {
        return initialX;
    }
    private int getInitialY() {
        return initialY;
    }
    private int getTargetX() {
        return targetX;
    }
    private int getTargetY() {
        return targetY;
    }
    private HashMap<Tile, Tile> getT() {
        return t;
    }
    public Stack getPath() {
        return path;
    }
}
