package GUI;

public class Tile extends Hexagon {

    //TODO: add Building and Units variables after Building and Unit class are occurred.
    private boolean isPassable;
    private int i,j;


    public Tile(double x, double y, double radius) {
        super(x, y, radius);
        isPassable=false;
    }

    public void setCoordinates(int i,int j){
        this.i=i;
        this.j=j;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
