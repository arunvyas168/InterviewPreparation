package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {3, 1, 1, 2, 2,1};
        boolean partitionPossible = ifPartitionPossible(array);
        System.out.println(partitionPossible);
    }

    public static boolean ifPartitionPossible(int[] array) {
        boolean returnValue = false;
        int sum = 0;
        for (int value : array) {
            sum = sum + value;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int requiredValue = sum / 2;
        return subsetSum(array, requiredValue);
    }

    public static boolean subsetSum(int[] array, int sum){
        boolean[][] dp = new boolean[array.length+1][sum+1];
        for(int i=0;i<=array.length;i++){
            dp[i][0] = true;
        }

        for(int i=1; i<=array.length;i++){
            for (int j=1;j<=sum;j++){
                if(j<array[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j] = (dp[i-1][j-array[i-1]])||(dp[i-1][j]);
                }
            }
        }
        return dp[array.length][sum];
    }
}
