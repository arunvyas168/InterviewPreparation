package com.company;

public class Main {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(6);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(8);
        System.out.println(minStack.getMin());
        System.out.println("******************************");
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());
        System.out.print(minStack.pop()+" ");
        System.out.println(minStack.getMin());



    }
}
