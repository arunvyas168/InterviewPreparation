package com.company;

import java.util.HashMap;

/**
 *  google-interview-questions

 Given a Pattern and a dictionary, print out all the strings that match the pattern.
 where a character in the pattern is mapped uniquely to a character in the dictionary ( this is what i was given first).

 e.g 1. ("abc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "cdf"
 2. ("acc" , <"cdf", "too", "hgfdt" ,"paa">) -> output = "too", "paa"

 */


public class Main {

    public static void main(String[] args) {
	    String[] array =  {"cdf", "too", "hgfdt" ,"paa"};
        String pattern1 = "abc";
        printPatternMappedString(array,pattern1);
        System.out.println();
        String[] array2 = {"cdf", "too", "hgfdt" ,"paa"};
        String pattern2 = "acc";
        printPatternMappedString(array2,pattern2);
    }

    public static void printPatternMappedString(String[] array, String pattern){
        char[] pat = pattern.toCharArray();
        for (String s : array){
            char[] word = s.toCharArray();
            printIsEncryption(pat,word);
        }
    }

    public static void printIsEncryption(char[]pattern, char[] word){
        HashMap<Character,Character> patternMap = new HashMap<>();
        HashMap<Character,Character> stringMap = new HashMap<>();
        if (pattern.length!=word.length){
            return;
        }
        for (int i=0;i<pattern.length;i++){
            if (!patternMap.containsKey(pattern[i])){
                if (stringMap.containsKey(word[i])){
                    return;
                }else {
                    patternMap.put(pattern[i],word[i]);
                    stringMap.put(word[i],pattern[i]);
                }
            }else {
                if(patternMap.get(pattern[i]) != word[i]){
                    return;
                }
            }
        }
        System.out.print(new String(word)+ " ");
    }
}
