package com.company;

public class Main {

    public static void main(String[] args) {
        int[] input = {5,3,4,7,9,8,2,1,6};
        mergeSort(input,0,input.length-1);
        for (int i:input){
            System.out.println(i+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] array, int start, int end){
        if (start<end){
            int mid = start + (end-start)/2;
            mergeSort(array,start,mid);
            mergeSort(array,mid+1,end);
            merge(array,start,mid,end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end){
        int[] temp = new int[array.length];
        for (int i=start; i<=end;i++){
            temp[i] = array[i];
        }
        int ptr1 = start;
        int ptr2 = mid+1;
        int arrayIndex = start;

        while ((ptr1<=mid)&&(ptr2<=end)){
            if (temp[ptr1]<=temp[ptr2]){
                array[arrayIndex] = temp[ptr1];
                ptr1++;
            }else {
                array[arrayIndex] = temp[ptr2];
                ptr2++;
            }
            arrayIndex++;
        }
        while (ptr1<=mid){
            array[arrayIndex] = temp[ptr1];
            ptr1++;
            arrayIndex++;
        }
        while (ptr2<=end){
            array[arrayIndex] = temp[ptr2];
            ptr2++;
            arrayIndex++;
        }
    }
}
