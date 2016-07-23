package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String input = "ABCD";
        char[] result = new char[input.length()];
        int[] count = new int[input.length()];
        Arrays.fill(count,1);
        printStringPermutation(input,count, result,0);
        System.out.println("*****************************");
        printStringCombination(input,count,0,result,0);
        System.out.println("*****************************");
        System.out.println(generateParenthesis(3));
    }
    public static void printStringPermutation(String input, int[] count, char[] result, int level){
        if(result.length == level){
            System.out.println(String.copyValueOf(result));
        }
        for(int i=0;i<input.length();i++){
            if (count[i] == 0){
                continue;
            }
            result[level] = input.charAt(i);
            count[i]--;
            printStringPermutation(input,count, result,level+1);
            count[i]++;
        }
    }

    public static void printStringCombination(String input, int[] count, int pos, char[] result, int len){
        print(result,len);
        for (int i=pos;i<input.length();i++){
            if(count[i] == 0){
                continue;
            }
            result[len] = input.charAt(i);
            count[i]--;
            printStringCombination(input,count,i,result,len+1);
            count[i]++;
        }
    }

    public static void print(char[] result, int len){
        System.out.print("{");
        for(int i=0;i<len;i++){
            System.out.print(result[i]);
        }
        System.out.println("}");
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
    }
    /*
    left and right represents the remaining number of ( and ) that need to be added.
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
    */
    public static void dfs(ArrayList<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }
}
