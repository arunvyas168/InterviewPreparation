package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] preOrderArray = {40,20,10,30,25,60,50,70};
        Node tree = constructBST(preOrderArray);
        preOrderPrint(tree);
        System.out.println();
    }

    public static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*
        1. add 1st element as root and push to stack
        2. for every element in array, pop all element from stack till stack top is smaller tha array element
        3. once find pop it add the array elemnt to right and push new element
        4. if no element found peek
    */

    public static Node constructBST(int[] array){
        Node root = new Node(array[0]);
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        for (int i=1;i<array.length;i++){
            Node temp = null;
            if((!stack.empty())&&(stack.peek().data>array[i])){
                temp = stack.peek();
                temp.left = new Node(array[i]);
                stack.push(temp.left);
            }else {
                while (!stack.empty() && array[i]>stack.peek().data){
                    temp = stack.pop();
                }
                if(temp!=null) {
                    temp.right = new Node(array[i]);
                    stack.push(temp.right);
                }
            }
        }
        return root;
    }

    public static void preOrderPrint(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderPrint(root.left);
        preOrderPrint(root.right);
    }



    /*
    *****for better coding we can write as:
    for (int i=1;i<array.length;i++){
            Node temp = null;
            while (!stack.empty() && array[i]>stack.peek().data){
                temp = stack.pop();
            }
            if(temp!=null){
                temp.right = new Node(array[i]);
                stack.push(temp.right);
            }else {
                temp = stack.peek();
                temp.left = new Node(array[i]);
                stack.push(temp.left);
            }
        }*/


}
