package com.company;

public class Main {

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        System.out.println(longestPalindromeSubSequence(seq));
    }

    public static int longestPalindromeSubSequence(String str){
        int[][]dp = new int[str.length()][str.length()];
        char[] charArray = str.toCharArray();

        //We know for sure that each character is palindrome of length 1;
        for (int i=0;i<dp.length;i++){
            dp[i][i] = 1;
        }

        //Fill the DP array
        for (int len = 2;len<=str.length();len++){
            int start = 0;
            int end = len-1;
            while (end<str.length()){
                if(charArray[start]==charArray[end]){
                    dp[start][end] = 2+dp[start+1][end-1];
                }else {
                    dp[start][end] = Math.max(dp[start][end-1],dp[start+1][end]);
                }
                start++;end++;
            }
        }

        /*for (int i=0;i<dp.length;i++){
            System.out.print("{");
            for (int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println("}");
        }*/


        return dp[0][charArray.length-1];
    }
}
