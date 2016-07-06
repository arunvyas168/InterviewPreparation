package com.company;

public class Main {

    public static void main(String[] args) {
	    String str1 = "abcdaf";
        String str2 = "zbcdf";
        int length = longestCommonSubstring(str1.toCharArray(),str2.toCharArray());
        System.out.println("The length of longest common substring is: "+ length);
    }

    public static int longestCommonSubstring(char[] str1,char[] str2){
        int dp[][] = new int[str1.length+1][str2.length+1];
        int maxI = 0;
        int maxJ = 0;
        for (int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                    if(dp[maxI][maxJ] < dp[i][j]){
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }

        //Backtracking and finding the actual substring
        int i =maxI;
        int j =maxJ;
        while((i>0)&&(j>0)){
            if(dp[i][j]!= 0){
                System.out.print(str1[i-1]+" ");
                i--;
                j--;
            }else {
                break;
            }
        }
        System.out.println();



        return dp[maxI][maxJ];

    }
}
