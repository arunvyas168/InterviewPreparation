package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 3, 6, 6};
        printDuplicates(array);
    }

    public static void printDuplicates(int[] array) {
        int len = array.length;
        for(int i=0;i<len;i++) {
            array[array[i]%len] += len;
        }
        for (int i=0;i<len;i++){
            if (array[i]-len >= len){
                System.out.println(i+" is repeated "+array[i]/len+"-times.");
            }
        }
        /*
        This code will get the original array.
        for (int i = 0; i< len; i++) {
            array[i] = array[i] % len;
        }*/
    }
}