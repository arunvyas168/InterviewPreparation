package com.company;

/*
"Given an array of positive integers and a target total of X, find if there exists a contiguous subarray with sum = X

[1, 3, 5, 18]   X = 8  Output: True
                X = 9  Output: True
                X = 10 Output: False
                X = 40 Output :False"
*/

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,20,4,6,10,2,3,10,8};
        int key = 18;
        boolean isSubArrayWithSum = contiguousSubArrayWithSum(array,key);
        System.out.println(isSubArrayWithSum);
        subArrayWithSum(array,key);
        int[] array2 = {10, 2, -2, -20, 10};
        int key2 = -10;
        subArrayWithSum(array2,key2);
    }
    /* Handles array with negative value and even if sum is negative */
    public static void subArrayWithSum(int[] array, int sum){
        System.out.println("************ For sum = "+sum+" ***************");
        HashMap<Integer, Integer> hm = new HashMap<>();
        int curSum = 0;
        for (int i=0;i<array.length;i++){
            curSum += array[i];
            if (curSum == sum){
                System.out.println("Sub-Array is: 0 to "+ i );
            }
            else if (hm.containsKey(curSum-sum)){
                System.out.println("Sub-Array is: "+ (hm.get(curSum-sum)+1) +" to "+ i );
            }
            hm.put(curSum,i);
        }
    }



    /* Will not handle negative numbers */
    public static boolean contiguousSubArrayWithSum(int[] array, int key){
        int sum = 0;
        int startPtr = 0;
        int endPtr = 0;

        while (endPtr<array.length){
            if(sum+array[endPtr] < key){
                sum = sum + array[endPtr];
                endPtr++;
            }else if(sum+array[endPtr] == key){
                return true;
            }else {
                sum = sum - array[startPtr];
                startPtr++;
            }
            if(endPtr<startPtr){
                endPtr = startPtr;
                sum =0;
            }
        }
        return false;
    }
}
