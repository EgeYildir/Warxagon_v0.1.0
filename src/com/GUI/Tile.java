package GUI;

public class Tile extends Hexagon {

    //TODO: add Building and Units variables after Building and Unit class are occurred.
    private boolean isPassable;
    private int i,j;


    public Tile(double x, double y, double radius) {
        super(x, y, radius);
        isPassable=true;
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
    public double distanceBetweenTiles(Tile t){
        double x1=this.getLayoutX();
        double y1=this.getLayoutY();
        double x2=t.getLayoutX();
        double y2=t.getLayoutY();
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
    public  boolean isNeighbor(Tile t){
        double a=this.distanceBetweenTiles(t);
        return  a>1&&a<=Grid.neighborRad*Math.sqrt(3);
    }
    public boolean equals(Tile t) {
        return (this.getI() == t.getI()) && (this.getJ() == t.getJ());
    }

}
