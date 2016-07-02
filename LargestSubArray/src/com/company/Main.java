package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] input = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(largest_subArray_with_EqualZeroAndOne(input));
    }

/*
    Largest subArray with equal number of 0s and 1s
*/
    public static int largest_subArray_with_EqualZeroAndOne(int[] array){
        int[] temp = new int[array.length];
        for(int i=0;i<array.length;i++){
            if (array[i]==0){
                temp[i]=-1;
            }else {
                temp[i]=array[i];
            }
        }
        return largest_subArray_withSumZero(temp);
    }

/*
    Find the largest subArray with 0 sum
*/

    public static int largest_subArray_withSumZero(int[] temp){
        Map<Integer,Integer> SumIndexMap = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        int leftBound = -1;

        for(int i=0;i<temp.length;i++){
            sum += temp[i];

            if ((temp[i]==0)&&(max_len==0)){
                max_len = 1;
            }
            if (sum == 0){
                max_len = i+1;
            }
            Integer prev_i = SumIndexMap.get(sum);
            if(prev_i!=null){
                max_len = Math.max(max_len,i-prev_i);
            }else {
                SumIndexMap.put(sum,i);
            }
        }
        return max_len;
    }


}
