package com.company;

import java.util.Stack;

/**
 * Created by arun on 7/29/16.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack(){
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    public void push(int value){
        if (!stack.isEmpty()){
            stack.push(value);
            minStack.push(Math.min(value,minStack.peek()));
        }else {
            stack.push(value);
            minStack.push(value);
        }
    }

    public int pop(){
        if (stack.isEmpty()){
            return -1;
        }
        minStack.pop();
        return stack.pop();
    }

    public int getMin(){
        return minStack.peek();
    }
}
