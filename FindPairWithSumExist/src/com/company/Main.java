package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] array = {2,4,6,3,8,9,1,0,10};
        int sum = 7;
        boolean isSumExist = findIfSumExist_one(array, sum);
        System.out.println(isSumExist);
        isSumExist = findIfSumExist_two(array, sum);
        System.out.println(isSumExist);
    }

    /*
        Method: 1
    */
    public static boolean findIfSumExist_one(int[] array, int sum){         //O(n+nLog(n))
        Arrays.sort(array);                                             //O(nlog(n)) TimSort
        int start = 0;
        int end = array.length;
        while (start<end){                                              //O(n)
            if(array[start]+array[end-1] == sum){
                return true;
            }else if(array[start]+array[end-1] < sum){
                start++;
            }else {
                end--;
            }
        }
        return false;
    }

    /*
       Method: 2
   */
    public static boolean findIfSumExist_two(int[] array, int sum){
        Map<Integer,Boolean> integerBooleanMap = new HashMap<Integer, Boolean>();
        for(int i: array){
            if(sum == i) return true;
            int temp = sum-i;
            if(integerBooleanMap.get(temp)!=null){
                return true;
            }else {
                integerBooleanMap.put(i,true);
            }
        }

        return false;
    }

}
