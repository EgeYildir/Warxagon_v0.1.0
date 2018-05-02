package com.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Path {
    private int initialX, initialY;
    private int targetX, targetY;
    private Tile[][] grid;
    private Stack path;
    private ArrayList<Tile> frontier;
    private ArrayList<Tile> visited;
    private HashMap<Tile,Tile> t;


    public Path(Tile initialTile, Tile targetTile, Tile[][] grid) {
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
        this.getFrontier().add(this.getGrid()[this.getInitialX()][this.getInitialY()]);
        this.getVisited().add(this.getGrid()[this.getInitialX()][this.getInitialY()]);
        while (!(this.getFrontier().isEmpty())) {
            Tile current = this.getFrontier().get(0);
            this.getFrontier().remove(0);
            ArrayList<Tile> n = getNeighbors(current);
            while (!(n.isEmpty())) {
                if (this.getVisited().contains(n.get(0))) {
                    n.remove(0);
                } else {
                    if (n.get(0).equals(this.getGrid()[targetX][targetY])) {
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
        this.getPath().push(this.getGrid()[targetX][targetY]);
        Tile temp = this.getGrid()[targetX][targetY];
        while (!(this.getGrid()[initialX][initialY].equals(temp))) {
            this.getPath().add(this.getT().get(temp));
            temp = this.getT().get(temp);
        }
        this.getPath().pop();


    }
    private Tile[][] getGrid() {
        return grid;
    }
    private ArrayList<Tile> getNeighbors(Tile t) {
        ArrayList<Tile> r = new ArrayList<>();
        int x1 = t.getI();
        int y1 = t.getJ();
        for (int i = x1 - 1; i <= x1 + 1; i++) {
            for (int j = y1 - 1; j <= y1 + 1; j++) {
                if (i > -1 && j > -1 && (i != x1 || j != y1) && (i != this.grid.length && j != this.grid[0].length)) {
                    if (LayoutDesigner.isNeighbor(t, this.grid[i][j]) && this.grid[i][j].isPassable()) {
                        r.add(this.grid[i][j]);

                    }
                }

            }

        }
        return r;
    } //needa additional methods to work
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
