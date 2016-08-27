package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int number = 8;
        generateFibonacci(number);
        System.out.println();
        int start = 1;
        while (start<=number){
            System.out.print(recursiveGenerateFib(start)+" ");
            start++;
        }

        System.out.println();
        int[] memo = new int[number+1];
        start = 1;
        while(start<=number){
            System.out.print(recursiveFib_memo(start,memo)+" ");
            start++;
        }
        System.out.println();

    }

    //memoization
    public static int recursiveFib_memo(int number, int[] memo){

        if (number == 0){
            memo[number] = 0;
            return 0;
        }else if (number == 1){
            memo[number] = 1;
            return 1;
        }else {
            if(memo[number]==0){
                return memo[number] = (recursiveFib_memo(number-1, memo)+recursiveFib_memo(number-2, memo));
            }else {
                return memo[number];
            }
        }

    }

    public static void generateFibonacci(int number){
        int a = 0;
        int b = 1;
        int fib = 1;
        while (number>0){
            System.out.print(fib+" ");
            fib = a+b;
            a = b;
            b = fib;
            number--;
        }
    }

    public static int recursiveGenerateFib(int number){
        if (number==0){
            return 0;
        }else if (number ==1){
            return 1;
        }else {
            return(recursiveGenerateFib(number-1)+recursiveGenerateFib(number-2));
        }
    }
}
