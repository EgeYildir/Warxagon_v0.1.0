package gui;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Grid extends HashMap<Pair<Integer,Integer>,Tile> {
    private int width;
    private int height;
    private int i;



    private int j;
    private Tile startLocation1,startLocation2; //preset starting locations for players.

    public Grid(int xSize,int ySize) {
        generateMap(xSize,ySize);
        i=xSize;
        j=ySize;
        this.startLocation1 = this.get(0,0);
        this.startLocation2 = this.get(0,2);
        this.width=xSize;
        this.height=ySize;
    }

    private void generateMap(int xSize,int ySize){
        double radius=70;
        double initialX=  (radius/2);
        double initialY= (radius*Math.sqrt(3)/2);
        double slip=Math.sqrt(3)*radius/2;

        for(double i=0,x=initialX;i<xSize;i++,x+=radius*3/2){
            for(double j=0,y=initialY;j<ySize;j++,y+=radius*Math.sqrt(3)){
                if(i%2==0) add(new Tile(x,y+slip,radius),(int)i,(int)j);
                else add(new Tile(x,y,radius),(int)i,(int)j);

            }
        }
        this.startLocation1 =  this.get(0,0);
        this.startLocation2 = this.get(1,1);
    }


    private void add(Tile tile,int i,int j){
        tile.setCoordinates(i,j);
        put(new Pair<>(i,j),tile);
    }

    public Tile get(int i,int j){
        return get(new Pair<>(i,j));
    }
    public int getSizeX(){return width;  }
    public int getSizeY(){return height;  }
    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }

    //necessary methods for pathfinder
    public ArrayList<Tile> getNeighbors(Tile t) {
        ArrayList<Tile> r = new ArrayList<>();
        int x1 = t.getI();
        int y1 = t.getJ();
        for (int i = x1 - 1; i <= x1 + 1; i++) {
            for (int j = y1 - 1; j <= y1 + 1; j++) {
                if (i > -1 && j > -1 && (i != x1 || j != y1) && (i != this.getSizeX() && j != this.getSizeY())) {
                    if (t.isNeighbor(this.get(i,j)) && this.get(i,j).isPassable()) {
                        r.add(this.get(i,j));

                    }
                }

            }

        }
        return r;
    }

    public ArrayList<Tile> getAllNeighbors(ArrayList<Tile> t){
        ArrayList<Tile> r = new ArrayList<>();
        for(int k = 0; k<0;k++) {
            int x1 = t.get(k).getI();
            int y1 = t.get(k).getJ();
            for (int i = x1 - 1; i <= x1 + 1; i++) {
                for (int j = y1 - 1; j <= y1 + 1; j++) {
                    if (i > -1 && j > -1 && (i != x1 || j != y1) && (i != this.getSizeX() && j != this.getSizeY())) {
                        if (t.isNeighbor(this.get(i, j)) && this.get(i, j).isPassable()) {
                            r.add(this.get(i, j));

                        }
                    }

                }

            }
        }
        return r;
    }


    public Tile getStartLocation1() {
        return startLocation1;
    }

    public Tile getStartLocation2() {
        return startLocation2;
    }
}
