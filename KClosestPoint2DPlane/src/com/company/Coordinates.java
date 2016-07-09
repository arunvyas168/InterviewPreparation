package com.company;

/**
 * Created by arun on 7/9/16.
 */
public class Coordinates implements Comparable<Coordinates> {
    private int x;
    private int y;
    private double distanceFromOrigin;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
        this.distanceFromOrigin = Math.hypot(x,y); //distance from (0,0)
    }

    @Override
    public int compareTo(Coordinates o) {
        return Double.valueOf(o.distanceFromOrigin).compareTo(this.distanceFromOrigin);
    }

    @Override
    public String toString(){
        return "X: "+this.x+ " and Y: "+this.y;
    }
}
