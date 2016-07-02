package com.company;

public class Main {

    public static void main(String[] args) {
        int number = 5;
        generateFibonacci(number);
        System.out.println();
        int start = 1;
        while (start<=number){
            System.out.print(recursiveGenerateFib(start)+" ");
            start++;
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
