package com.company;

/*
"Given an array of positive integers and a target total of X, find if there exists a contiguous subarray with sum = X

[1, 3, 5, 18]   X = 8  Output: True
                X = 9  Output: True
                X = 10 Output: False
                X = 40 Output :False"
*/

public class Main {

    public static void main(String[] args) {
        int[] array = {1,20,4,6,10,2,3};
        int key = 18;
        boolean isSubArrayWithSum = contiguousSubArrayWithSum(array,key);
        System.out.println(isSubArrayWithSum);
    }

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
