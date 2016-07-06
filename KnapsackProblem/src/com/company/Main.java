package com.company;

// https://www.youtube.com/watch?v=8LusJS5-AGo

public class Main {

    public static void main(String[] args) {
        //int[] val = {60, 100, 120};
        //int[] wt = {10, 20, 30};
        //int  W = 50;
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int maxVal = findMaxValueForGivenWeight(val,wt,W);
        System.out.println("The max value that can be picked is: "+maxVal);
    }
    public static int findMaxValueForGivenWeight(int[] val, int[] weight, int TotalWeight){
        //Temp Memory for dynamic programming
        int[][] dp = new int[weight.length+1][TotalWeight+1];

        //Compute the Array using
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(j >= weight[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-(weight[i-1])]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        //Printing the Actual elements
        int i = dp.length-1;
        int j = dp[0].length-1;
        while ((i>0)&&(j>0)){
            if(dp[i-1][j]>=val[i-1]+dp[i-1][j-(weight[i-1])]){
                //if the value is coming from top then don't print
                i--;
            }else {
                //if the value is coming from the val[] array then print it
                System.out.println("Item with weight "+weight[i-1]+" with value: "+ val[i-1]);
                j= j-weight[i-1];
                i--;
            }
        }


        return dp[weight.length][TotalWeight];
    }
}
