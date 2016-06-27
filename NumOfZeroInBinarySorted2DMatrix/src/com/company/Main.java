package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1},
                {0,1,1},
                {1,1,1}
        };
        System.out.println(findNumZero(matrix));
        int[][] matrix2 = {
                {0,0},
                {0,0},
        };
        System.out.println(findNumZero(matrix2));
    }

    public static int findNumZero(int[][] array){
        int sum = 0;
        int rowStart = 0;
        int columnEnd = array[0].length-1;
        while ((rowStart<array.length)&&(columnEnd >=0)){
            if(array[rowStart][columnEnd] == 1){
                columnEnd--;
            }else{
                sum = sum+(columnEnd+1);
                rowStart++;
            }
        }

        return sum;
    }
}
