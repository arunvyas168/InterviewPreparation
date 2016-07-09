package com.company;

/*
    Given some number of floors and some number of eggs,
    what is the minimum number of attempts it will take to find out from which floor egg will break.
*/

public class Main {

    public static void main(String[] args) {
        int floors = 36;
        int eggs = 2;
        int minThrows = findMinThrows(eggs,floors);
        System.out.println("Minimum number of trials in worst case with "+ eggs +
                " eggs and "+ floors +" floors is "+minThrows);
    }

    public static int findMinThrows(int eggs, int floors){
        int[][] dp = new int[eggs+1][floors+1];

        for (int i=0;i<=floors;i++){
            dp[1][i] = i;
        }
        int c =0;
        for(int e=2;e<=eggs;e++){
            for(int f=1;f<=floors;f++){
                dp[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(dp[e-1][k-1], dp[e][f-k]);
                    if(c<dp[e][f]){  //getting the minimum number of throws out of all possibility
                        dp[e][f] = c;
                    }
                }
            }
        }

        return dp[eggs][floors];
    }
}
