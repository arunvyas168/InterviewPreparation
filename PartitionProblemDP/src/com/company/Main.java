package com.company;

/*
    Partition problem is to determine whether a given set can be partitioned into two subsets
    such that the sum of elements in both subsets is same.

    Idea is to use "subset sum" code expect for the fact now sum = (sum of array)/2;
    make sure sum is even. odd means there can not be a partition.
*/

public class Main {

    public static void main(String[] args) {
        int[] array = {3,1,1,2,2,1};
        System.out.println(findPartition(array));
    }
    public static boolean findPartition(int[] array){
        int sum = 0;
        int i,j;
        for(i=0;i<array.length;i++){
            sum += array[i];
        }
        if (sum%2!=0){
            return false;
        }
        boolean dp[][] = new boolean[array.length+1][(sum/2)+1];

        for (i=0;i<dp.length;i++){
            dp[i][0] = true;
        }
        for(j=1;j<dp[0].length;j++){
            dp[0][j] = false;
        }

        for(i=1;i<dp.length;i++){
            for(j=1;j<dp[i].length;j++){
                if(j < array[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i-1]];
                }
            }
        }
        return dp[array.length][sum/2];
    }
}
