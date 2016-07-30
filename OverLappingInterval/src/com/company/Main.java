package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Tuple> list = new ArrayList<>();
        list.add(new Tuple(1,4));
        list.add(new Tuple(14,19));
        list.add(new Tuple(6,10));
        Tuple merge = new Tuple(13,17);
        mergeOverlappingSet(list,merge);

        //Print List
        for (Tuple t : list){
            System.out.println(t.toString());
        }
        System.out.println("**********************");
        //Problem 2:
        ArrayList<Tuple> list2 = new ArrayList<>();
        list2.add(new Tuple(1,4));
        list2.add(new Tuple(14,19));
        list2.add(new Tuple(6,10));
        list2.add(new Tuple(13,17));
        List<Tuple> result = nonOverlappingSet(list2);
        //Print List
        for (Tuple t : result){
            System.out.println(t.toString());
        }
    }

    /**
     * Here we have a non-overlapping list and given an overlapping interval we need to merge
     */
    public static void mergeOverlappingSet(ArrayList<Tuple> list, Tuple merge){
        Collections.sort(list);
        boolean added = false;
        for(int i=0;i<list.size();i++){
            Tuple current = list.get(i);
            if(current.maxRange>merge.minRange){
                list.remove(i);
                list.add(i,new Tuple(Math.min(current.minRange,merge.minRange),Math.max(current.maxRange,merge.maxRange)));
                added=true;
                break;
            }else if(current.minRange>merge.maxRange){
                if (i == 0){
                    list.add(0,merge);
                }else {
                    list.add(i-1,merge);
                }
                added=true;
                break;
            }
        }
        if (!added){
            list.add(merge);
        }
    }


    /**
     * Here we have overlapping tuple and we need to make it non-overlapping
     */
    public static List<Tuple> nonOverlappingSet(ArrayList<Tuple> list){
        Collections.sort(list);
        if (list.size() == 0){
            return list;
        }
        List<Tuple> result = new ArrayList<>();
        int index =0;
        result.add(list.remove(0));
        while (!list.isEmpty()){
            Tuple resultFront = result.get(index);
            Tuple listFront = list.remove(0);
            if (resultFront.maxRange>=listFront.minRange){
                result.remove(index);
                result.add(index,new Tuple(resultFront.minRange, Math.max(resultFront.maxRange, listFront.maxRange)));
            }else {
                result.add(listFront);
            }
            index++;
        }
        return result;
    }

}
