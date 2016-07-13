package com.company;

import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String input = "ABCD";
        printStringPermutation(input);
        System.out.println("**** Handles Duplicate ****");
        String input2 = "AABC";
        printStringPermutation(input2);
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

        stringPermutation_Util(str,count,result,0);
    }

    public static void stringPermutation_Util(char[]str, int[]count, char[]result, int level){
        if(level == result.length){
            printArray(result);
        }

        for(int i=0;i<count.length;i++){
            if(count[i] == 0){
                continue;
            }
            result[level] = str[i];
            count[i]--;
            stringPermutation_Util(str,count,result,level+1);
            count[i]++;
        }

    }

    public static void printArray(char[] result){
        for(char c : result){
            System.out.print(c);
        }
        System.out.println();
    }
}
/*
Sample Output:
1.
N! ways
ABCD
ABDC
ACBD
ACDB
ADBC
ADCB
BACD
BADC
BCAD
BCDA
BDAC
BDCA
CABD
CADB
CBAD
CBDA
CDAB
CDBA
DABC
DACB
DBAC
DBCA
DCAB
DCBA

2.
**** Handles Duplicate ****
n!/(each count!) 4!/2!
AABC
AACB
ABAC
ABCA
ACAB
ACBA
BAAC
BACA
BCAA
CAAB
CABA
CBAA

 */