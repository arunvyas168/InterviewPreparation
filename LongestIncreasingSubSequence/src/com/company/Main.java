package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array1 = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println(longestIncreasingSubSequence(array1));
        int[] array2 = { 3, 4, -1, 0, 6, 2 ,3};
        System.out.println(longestIncreasingSubSequence(array2));
    }

    public static int longestIncreasingSubSequence(int[] array){

        /*
           ********* Main Logic: *************
        */
        int[] auxArray = new int[array.length];
        Arrays.fill(auxArray,1);
        for(int i=1;i<array.length;i++){
            int j = 0;
            while (j<i){
                if (array[j]<array[i]){
                    if(auxArray[i]<(auxArray[j]+1)){
                        auxArray[i] = auxArray[j]+1;
                    }
                }
                j++;
            }
        }


        //Find the maxIndex in the aux array.
        int maxIndex = 0;
        for (int i=0;i<auxArray.length;i++){
            if (auxArray[maxIndex] < auxArray[i]){
                maxIndex = i;           //max value in aux array is the LIS
            }
        }


        //print the actual solution
        System.out.print(array[maxIndex]+" ");
        int newMax = maxIndex;
        for(int i=maxIndex-1;i>=0;i--){
            if (auxArray[i]<auxArray[newMax]){
                System.out.print(array[i]+" ");
                newMax = i;
            }
        }
        System.out.println();

        //return max in the auxArray
        return auxArray[maxIndex];
    }
}
