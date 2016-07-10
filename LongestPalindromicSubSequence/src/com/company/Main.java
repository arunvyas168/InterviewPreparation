package com.company;

public class Main {

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        System.out.println(longestPalindromeSubSequence(seq));
    }

    public static int longestPalindromeSubSequence(String str) {
        int dp[][] = new int[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        for(int l = 2; l <= str.length(); l++){
            for(int i = 0; i < str.length()-l+1; i++){
                int j = i + l - 1;
                if(l == 2 && str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2;
                }else if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][str.length()-1];
    }
}
