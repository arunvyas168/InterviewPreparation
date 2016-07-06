package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        int len = largestSubstringWithoutRepetition(str1.toCharArray());
        System.out.println("The length of longest Substring without repetition is: "+ len);
        String str2 = "ABDEFGABEF";
        len = largestSubstringWithoutRepetition(str2.toCharArray());
        System.out.println("The length of longest Substring without repetition is: "+ len);
    }

    public static int largestSubstringWithoutRepetition(char[] str){
        int max_len = 0;
        int currentLen =0;
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<str.length;i++){
            if(!set.contains(str[i])){
                currentLen++;
                set.add(str[i]);
            }else {
                if (max_len<currentLen){
                    max_len = currentLen;
                }
                currentLen = 0;
                set.clear();
            }
        }

        return max_len;
    }
}
