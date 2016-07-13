package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String input = "AABC";
        printStringPermutation(input);
    }

    public static void printStringPermutation(String input){
        Map<Character,Integer> map = new TreeMap<>();
        for (int i=0;i<input.length();i++){
            if (!map.containsKey(input.charAt(i))){
                map.put(input.charAt(i),1);
            }else {
                int c = map.get(input.charAt(i));
                map.put(input.charAt(i),c+1);
            }
        }

        char[] str = new char[map.size()];
        int[] count = new int[map.size()];
        char[] result = new char[input.length()];
        int index = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }

        stringPermutation_Util(str,count,0,result,0);
    }

    public static void stringPermutation_Util(char[]str, int[]count, int pos, char[]result, int len){

        printArray(result, len);


        for(int i=pos;i<count.length;i++){
            if(count[i] == 0){
                continue;
            }
            result[len] = str[i];
            count[i]--;
            stringPermutation_Util(str,count,i,result,len+1);
            count[i]++;
        }

    }

    public static void printArray(char[] result, int len){
        for(int i=0;i<len;i++){
            System.out.print(result[i]);
        }
        System.out.println();
    }
}
