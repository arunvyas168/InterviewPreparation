package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String pattern1 = "abba";
        String str1 = "dog cat cat dog";
        System.out.println(wordPattern(pattern1,str1));
        System.out.println(wordPattern_doubleMap(pattern1,str1));
        String pattern2 = "abba";
        String str2 = "dog dog dog dog";
        System.out.println(wordPattern(pattern2,str2));
        System.out.println(wordPattern_doubleMap(pattern2,str2));
    }
    //Complexity is O(n^2)
    public static boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        if(arr.length!= pattern.length())
            return false;

        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))           //The tricky part o(N)
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }


    //Complexity is O(n) space Complexity is increased as we are using 2 map
    public static boolean wordPattern_doubleMap(String pattern, String str) {
        String[] strs = str.split(" ");

        if(pattern.length() != strs.length) return false;

        HashMap<Character, String> hm1 = new HashMap<Character, String>();
        HashMap<String, Character> hm2 = new HashMap<String, Character>();
        for(int i=0; i<pattern.length(); ++i){
            char c = pattern.charAt(i);
            if (!hm1.containsKey(c)){
                if(hm2.containsKey(strs[i])){
                    return false;
                }else {
                    hm1.put(c,strs[i]);
                    hm2.put(strs[i],c);
                }
            }else {
                if (!hm1.get(c).equals(strs[i])){
                    return false;
                }
            }
        }


        return true;
    }

    public static class Object{
        char c;
        String word;
        public Object(char c, String word){
            this.c = c;
            this.word = word;
        }
    }

}