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
    public EgyptianInfantry(){

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
