package com.company;

/*
    Find the K closest Coordinatess to the origin in 2D plane,
    given an array containing N Coordinatess.
    You can assume K is much smaller than N and N is very large.
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int k =5;
        List<Coordinates> list = new ArrayList<>();
        list.add(new Coordinates(1, 1));
        list.add(new Coordinates(1, 3));
        list.add(new Coordinates(-1, 1));
        list.add(new Coordinates(1, -1));
        list.add(new Coordinates(3, -1));
        list.add(new Coordinates(-1, -1));
        list.add(new Coordinates(-1, 3));
        list.add(new Coordinates(2, 2));
        printKClosestToOrigin(list,k);
    }

    public static void printKClosestToOrigin(List<Coordinates> list,int k){
        PriorityQueue<Coordinates> priorityQueue = new PriorityQueue<>();
        for(Coordinates c : list){
            if(priorityQueue.size()<k){
                priorityQueue.add(c);
            }else {
                if(priorityQueue.peek().compareTo(c) < 0){
                    priorityQueue.poll();
                    priorityQueue.add(c);
                }
            }
        }

        while (priorityQueue.size()!=0){
            System.out.println(priorityQueue.poll().toString());
        }
    }
}
