package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String str1 = "GeeksforGeeks";
        String str2 = "GeeksQuiz";
        System.out.println(longestCommonSubSequence(str1.toCharArray(),str2.toCharArray()));
        String str3 = "abcdaf";
        String str4 = "acbcf";
        System.out.println(longestCommonSubSequence(str3.toCharArray(),str4.toCharArray()));

    }

    public static int longestCommonSubSequence(char[] str1, char[] str2){
        //For Dynamic Programming initialize the array
        int[][] dp = new int[str1.length+1][str2.length+1];
        int max = 0;
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if(str1[i-1]==str2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        //Print the actual Sequence
        int i = dp.length-1;
        int j = dp[0].length-1;
        while ((i>0)&&(j>0)){
            if(dp[i][j] != Math.max(dp[i-1][j],dp[i][j-1])){
                System.out.print(str1[i-1]+" ");
                i--;
                j--;
            }else {
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else {
                    j--;
                }
            }
        }
        System.out.println();
        return max;
    }
}
