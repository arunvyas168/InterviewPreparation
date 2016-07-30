package com.company;

/**
 * Created by arun on 7/29/16.
 */
public class Tuple implements Comparable<Tuple>{
    int minRange;
    int maxRange;
    public Tuple(int minRange, int maxRange){
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.minRange-o.minRange;
    }

    @Override
    public String toString() {
        return "Tuple(" + minRange +
                ", " + maxRange +
                ')';
    }
}
