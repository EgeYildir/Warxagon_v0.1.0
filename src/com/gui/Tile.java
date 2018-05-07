package gui;

import engine.GameEngine;
import units.buildings.Building;
import units.soldiers.EgyptianInfantry;
import units.soldiers.HunInfantry;
import units.soldiers.RomanInfantry;
import units.soldiers.Soldier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Tile extends Hexagon {

    //TODO: add Building and Units variables after Building and Unit class are occurred.
    private boolean isPassable;
    private int i, j;
    private Building b;
    private List<Soldier> sols;
    private double r;

    public Tile(double x, double y, double radius) {
        super(x, y, radius);
        isPassable = true;
        this.b = null;
        this.r = radius;
        this.sols = new ArrayList<>();
    }

    public void setCoordinates(int i, int j) {
        this.i = i;
        this.j = j;
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

    public double distanceBetweenTiles(Tile t) {
        double x1 = this.getLayoutX();
        double y1 = this.getLayoutY();
        double x2 = t.getLayoutX();
        double y2 = t.getLayoutY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public boolean isNeighbor(Tile t) {
        double a = this.distanceBetweenTiles(t);
        return  a>1&&a<=this.r*Math.sqrt(3);
    }

    public boolean equals(Tile t) {
        return (this.getI() == t.getI()) && (this.getJ() == t.getJ());
    }

    public void setB(Building b) {
        this.b = b;
        this.isPassable = false;
    }

    public void battle(int i) { //Checks the soldiers in a tile and separates the nations and battles between nations.
        boolean rh = false;
        boolean he = false;
        boolean re = false;
        List<Soldier> romans = new ArrayList<>();
        List<Soldier> huns = new ArrayList<>();
        List<Soldier> egyptians = new ArrayList<>();
        if (i == 1) rh = true;
        else if (i == 2) he = true;
        else if (i == 3) re = true;
        if (rh) {
            List<Soldier> s = this.getSoldiers();
            Iterator a = s.iterator();
            Soldier o;
            while (a.hasNext()) {
                o = (Soldier) a.next();
                if (o instanceof RomanInfantry) romans.add(o);
                else if (o instanceof HunInfantry) huns.add(o);
            }
            battle(romans, huns);
        } else if (he) {
            List<Soldier> s = this.getSoldiers();
            Iterator a = s.iterator();
            Soldier o;
            while (a.hasNext()) {
                o = (Soldier) a.next();
                if (o instanceof HunInfantry) huns.add(o);
                else if (o instanceof EgyptianInfantry) egyptians.add(o);
            }
            battle(huns, egyptians);
        } else if (re) {
            List<Soldier> s = this.getSoldiers();
            Iterator a = s.iterator();
            Soldier o;
            while (a.hasNext()) {
                o = (Soldier) a.next();
                if (o instanceof RomanInfantry) romans.add(o);
                else if (o instanceof EgyptianInfantry) egyptians.add(o);
            }
            battle(romans, egyptians);
        }
    }

    public void battle(List<Soldier> s1, List<Soldier> s2) { //Separates the soldiers in each nations and battles.
        if (s1.size() > 0 && s2.size() > 0) {
            Iterator<Soldier> i1 = s1.iterator();
            Iterator<Soldier> i2 = s2.iterator();
            Soldier sol1;
            Soldier sol2;
            while (i1.hasNext() && i2.hasNext()) {
                sol1 = i1.next();
                sol2 = i2.next();
                battle(sol1, sol2);
            }

        }
    }

    public synchronized void battle(Soldier s1, Soldier s2) { //Takes individual soldiers in each nations for once recursion will be used.
        while (!s1.isDead && !s2.isDead) {
            Random rand = new Random();
            int x = rand.nextInt(10);
            if (x >= 5) {
                if (s1.getHealthPower() > 0 || s2.getHealthPower() > 0) {
                    if (s2.getDefensePower() > s1.getAttackPower()) {
                        s2.setDefensePower(s2.getDefensePower() - s1.getAttackPower());
                    } else if ((s2.getDefensePower() < s1.getAttackPower()) && s2.getDefensePower() > 0) {
                        s2.setHealthPower(s2.getHealthPower() + s2.getDefensePower() - s1.getAttackPower());
                        s2.setDefensePower(0);
                    } else {
                        s2.setHealthPower(s2.getHealthPower() - s1.getAttackPower());
                        s2.setDefensePower(0);
                    }
                }
            } else {
                if (s1.getHealthPower() > 0 || s2.getHealthPower() > 0) {
                    if (s1.getDefensePower() > s2.getAttackPower()) {
                        s1.setDefensePower(s1.getDefensePower() - s2.getAttackPower());
                    } else if ((s1.getDefensePower() < s2.getAttackPower()) && s1.getDefensePower() > 0) {
                        s1.setHealthPower(s1.getHealthPower() + s1.getDefensePower() - s2.getAttackPower());
                        s1.setDefensePower(0);
                    } else {
                        s1.setHealthPower(s1.getHealthPower() - s2.getAttackPower());
                        s1.setDefensePower(0);
                    }
                }
            }
            if (s1.getHealthPower() <= 0) {
                s1.setHealthPower(0);
                s1.setAttackPower(0);
                s1.setDefensePower(0);
                s1.isDead = true;
                this.removeSol(s1);
            }
            if (s2.getHealthPower() <= 0) {
                s2.setHealthPower(0);
                s2.setAttackPower(0);
                s2.setDefensePower(0);
                s2.isDead = true;
                this.removeSol(s2);
            }
        }
    }

    public synchronized int encounter() { //Search for tile whether which 2 nations are in and returns them to battle.
        boolean roman = false;
        boolean hun = false;
        boolean egyptian = false;

        List<Soldier> soldiers = this.getSoldiers();
        if (soldiers.size() > 1) {
            Iterator i = soldiers.iterator();
            while (i.hasNext()) {
                Soldier s = (Soldier) i.next();
                if (s instanceof RomanInfantry) {
                    roman = true;
                }
                if (s instanceof HunInfantry) {
                    hun = true;
                }
                if (s instanceof EgyptianInfantry) {
                    egyptian = true;
                }
            }
            if ((roman && hun)) {
                System.out.println("Roman and Hun troops are in the current tile. " + 1);
                return 1;
            } else if (hun && egyptian) {
                System.out.println("Hun and Egyptian troops are in the current tile. " + 2);
                return 2;
            } else if (roman && egyptian) {
                System.out.println("Roman and Egyptian troops are in the current tile. " + 3);
                return 3;
            }
        }
        return 0;
    }

    public List<Soldier> getSoldiers() {  //Return whole soldiers in a specific tile.
        List<Soldier> soldiers = GameEngine.soldiers;
        List<Soldier> sols = new ArrayList<>();
        Iterator i = soldiers.iterator();
        Soldier s;
        while (i.hasNext()) {
            s = (Soldier) i.next();
            if (this.getI() == s.getI() && this.getJ() == s.getJ()) {
                sols.add(s);
            }
        }
        return sols;
    }

    public synchronized void setSol(Soldier s) {
        //TODO: add given list to the sols arraylist and check for battles.
    }
    public synchronized void removeSol(Soldier s) {

    }
}