package com.units.soldiers.egyptian;

import com.grid.Grid;
import com.grid.Tile;
import com.main.Map;
import com.units.soldiers.Soldier;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class EgyptianInfantry extends Soldier{//Aynı zamanda bir soldier objesi olması game Enginedeki Arraylistlerde  bize kolaylık sağlıyor.
    ImageView source;//asıl işlem yapılacak image.
    private double dmg;//Şu anlık kullanılmıyor.
    private double velIndex;
    private boolean isInPath;//Eğer bir yolda yürüyorsa başka bir pathe sapmasını engelleyen boolean.


    Map map;
    private Tile currentTile;
    private int iIndex,jIndex;
    public EgyptianInfantry(Map map,int iIndex,int jIndex,int healthPower, int attackPower, int defensePower, int goldCost, int woodCost, int ironCost){
        super(healthPower, attackPower,  defensePower,  goldCost,  woodCost,  ironCost);
        isInPath=false;
        this.map=map;
        this.iIndex=iIndex;
        this.jIndex=jIndex;
        currentTile=map.getGrid().getGrid()[iIndex][jIndex];
        source=new ImageView(new Image("romanianInfantry.png"));
        source.setX(currentTile.getX()*80/7-30);
        source.setY(currentTile.getY()*80/7-30);

        refreshSize();
        map.getLayout().getChildren().add(source);

    }
    private void refreshSize(){//Zoom in zoom out larda responsive bir boyuta sahip olması için.
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                source.setFitHeight(Grid.radius);
                source.setFitWidth(Grid.radius);
                //if(map.isZoomed)
                //map.getLayout().getChildren().add(source);
            }
        }.start();
    }
    public void move(Tile[] tiles){//Aldığı queue ya da array'e bağlı gitmesini sağlması.
        velIndex=1D;

        new AnimationTimer(){
            int index=0;
            double start=System.currentTimeMillis();

            @Override
            public void handle(long now) {//Daha güzel bir algrotihma yazılır.
                isInPath=true;
                source.setY(tiles[index].getY()*80/7-30);
                source.setX(tiles[index].getX()*80/7-30);//80/7 Sorunu hala çözülmedi anlam veremiyorum bu oran hatasına.
                if(System.currentTimeMillis()-start>500) {
                    start=System.currentTimeMillis();
                    if(index<tiles.length-1) index++;
                    else{
                        iIndex=tiles[tiles.length-1].getI();
                        jIndex=tiles[tiles.length-1].getJ();
                        System.out.println("I set!");
                        isInPath=false;
                        stop();
                    }
                }
            }
        }.start();
        battle();
        System.out.println(this.toString());
            /*new AnimationTimer(){
                int index=0;
                @Override
                public void handle(long now) {
                    isInPath=true;
                    Tile tile=tiles[index];
                    double dist=Math.sqrt(Math.pow((tile.getX()*80/7-source.getX()),2)+Math.pow(tile.getY()*80/7-source.getY(),2));
                    double xVal=velIndex*(tile.getX()-source.getX())/80;
                    double yVal=velIndex*(tile.getY()-source.getY())/80;
                    source.setX(source.getX()+xVal*80/7);
                    source.setY(source.getY()+yVal*80/7);
                    if(dist<2){

                        if (index==tiles.length-1){
                            isInPath=false;
                            stop();
                        }
                        index++;
                    }
                }
            }.start();*/
    }

    @Override
    public Tile currentTile() {
        return currentTile;
    }

    public ImageView getSource() {
        return source;
    }

    @Override
    public int getI() {
        return iIndex;
    }

    @Override
    public int getJ() {
        return jIndex;
    }

    @Override
    public boolean isInPath() {
        return isInPath;
    }

    @Override
    public void setIsInPath(boolean a) {
        isInPath=a;
    }

    @Override
    public void battle(){
        if(currentTile.encounter()!=0){
            currentTile.battle(currentTile.encounter());
        }
    }

}
