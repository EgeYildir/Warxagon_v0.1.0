package units.buildings;


import gui.GUI;
import gui.Map;
import gui.Tile;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import units.soldiers.HunInfantry;
import units.soldiers.Soldier;


public abstract class Building {
    private int healthPower, woodCost, ironCost, foodCost;
    private boolean isComplete;
    private Tile t;
    private ImageView image;



    public Building(Tile t, int healthPower, int woodCost, int ironCost, int foodCost) {
        this.healthPower = healthPower;
        this.woodCost = woodCost;
        this.ironCost = ironCost;
        this.foodCost = foodCost;
        this.isComplete=false;
        this.t=t;
        this.t.setB(this);
        image = new ImageView(new Image(GUI.class.getResource("barrack.png").toExternalForm()));


    }

    public void setListener(Map map,Tile t){
        image.setOnMouseClicked(event -> {
            var a= map.getGrid().getNeighbors(t);
            System.out.println((int)(Math.random()*a.size()));
            System.out.println(a.size());
            System.out.println(a);
            Tile tile = a.get((int)(Math.random()*a.size()));
            Soldier sol = new HunInfantry(tile);
            tile.getSols().add(sol);
            sol.image.setTranslateX(tile.getTranslateX()-7+((int)(Math.random()*9)));
            sol.image.setTranslateY(tile.getTranslateY()-26+((int)(Math.random()*9)));
            map.getChildren().add(sol.image);



        });
    }

    public int getHealthPower() {
        return healthPower;
}

    public int getWoodCost() {
        return woodCost;
    }

    public int getIronCost() {
        return ironCost;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void build() {

    }
    public ImageView getImage() {
        return image;
    }

}
