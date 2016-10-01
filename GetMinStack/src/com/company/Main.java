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
        System.out.println("********** MIDDLE STACK ********************");

        MiddleStack midSt = new MiddleStack();
        midSt.push(1);
        System.out.println(midSt.getMid());
        midSt.push(2);
        System.out.println(midSt.getMid());
        midSt.push(3);
        System.out.println(midSt.getMid());
        midSt.push(4);
        System.out.println(midSt.getMid());
        System.out.println("POP:"+midSt.pop());
        System.out.println(midSt.getMid());
        midSt.deleteMid();
        System.out.println(midSt.getMid());
        midSt.deleteMid();
        System.out.println(midSt.getMid());
        midSt.deleteMid();
        System.out.println(midSt.getMid());
        midSt.deleteMid();
        System.out.println(midSt.getMid());


    }
}
