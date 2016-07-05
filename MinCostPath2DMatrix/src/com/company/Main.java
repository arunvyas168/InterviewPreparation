package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}
        };
        System.out.println("Minimum cost to reach from top left to bottom right is: "+findMinCostPath(matrix));
    }

    public static int findMinCostPath(int[][]array){
        int dp[][] = new int[array.length][array[0].length];
        dp[0][0] = array[0][0];
        //initialize array
        for (int i=1;i<dp.length;i++){
            dp[i][0] = dp[i-1][0] + array [i][0];
        }
        for (int j=1;j<dp[0].length;j++){
            dp[0][j] = dp[0][j-1] + array [0][j];
        }

        //dynamic programming of temp array to find min cost
        for(int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                dp[i][j] = array[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        //Backtracking and actually printing the path
        int i = dp.length-1;
        int j = dp[0].length-1;
        while ((i>0)&&(j>0)){
            System.out.print(array[i][j]+" ");
            if(dp[i-1][j]<dp[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        if(dp[0][1]<dp[1][0]){
            System.out.print(array[0][1]+" ");
        }else {
            System.out.print(array[1][0]+" ");
        }
        System.out.println(array[0][0]);



        return dp[dp.length-1][dp[0].length-1];
    }
}
