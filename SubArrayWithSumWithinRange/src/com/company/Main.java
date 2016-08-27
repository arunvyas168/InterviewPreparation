package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 4, 20, 3, 10, 5};
        int low = 5;
        int high = 35;
        printIndexWithSum(array,low,high);
    }

    /*Does not handles Negative:*/
    public static void printIndexWithSum(int[] array, int low, int high){
        int start = 0;
        int end = 0;
        int sum =0;
        while (end<array.length){
            if ((sum+array[end]>low)&&(sum+array[end]<high)){
                System.out.println(start+", "+end);
                sum = sum+array[end];
                end++;
            }else if(sum+array[end]<low){
                sum = sum+array[end];
                end++;
            }else{
                sum = sum - array[start];
                start++;
            }
        }
    }

}
