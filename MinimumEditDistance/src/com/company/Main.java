package com.company;

public class Main {

 /*
 * Given two strings how many minimum edits(update, delete or add) is needed to convert one string to another
 *
 * Time complexity is O(m*n)
 * Space complexity is O(m*n)
 */

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("The minimum edits to be made is: "+ minEditDistance(str1.toCharArray(),str2.toCharArray()));
    }

    public static int minEditDistance(char[] str1, char[] str2){
        int[][] dp = new int[str1.length+1][str2.length+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=j;
        }

        for (int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1[i-1]!=str2[j-1]){
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],(Math.min(dp[i][j-1],dp[i-1][j])));
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[str1.length][str2.length];
    }
}
