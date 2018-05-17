package gui;

public class CHECK {

    public static Checker buildingcheck=new Checker(5,3);


}
class Checker{

    int coolDown,
            limit,
            created;

    long startTime;

    boolean selected;

    public Checker(int coolDown,int limit){
        startTime = 0;
        this.coolDown = coolDown;
        created=1;
        selected=false;
        this.limit = limit;
    }
    public void increase(){created++;}
    public boolean canDo(int x, int y){
        boolean isAround = (x < 3) && (y < 3);
        if ( created <= limit && (System.currentTimeMillis()-startTime)/1000 > coolDown && selected && isAround){//( created < limit &&
            startTime = System.currentTimeMillis();
            created++;
            selected=false;
            return true;
        }
        return false;
    }
}
