package units.buildings;


import gui.Tile;

public abstract class Building {
    private int healthPower, woodCost, ironCost, foodCost;
    private boolean isComplete;
    private Tile t;

    public Building(Tile t, int healthPower, int woodCost, int ironCost, int foodCost) {
        this.healthPower = healthPower;
        this.woodCost = woodCost;
        this.ironCost = ironCost;
        this.foodCost = foodCost;
        this.isComplete=false;
        this.t=t;
        this.t.setB(this);
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

}
