package com.company;

import java.util.Stack;

/**
 * Created by arun on 7/3/16.
 */
public class BinaryTree {

    public static Node head;        // static variable used for recursion
    public static Node prev = null; // static variable used for recursion

    public void printInOrder(Node root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    public void printList(){
        Node current = this.head;
        while (current!=null){
            System.out.print(current.data+" ");
            current = current.right;
        }
    }

    public void binaryTreeToDoubleList(Node root){
        if (root==null){
            return;
        }
        binaryTreeToDoubleList(root.left);

        if(prev == null){
            this.head = root;
        }else {
            root.left=prev;
            this.prev.right = root;
        }
        this.prev = root;

        binaryTreeToDoubleList(root.right);
    }

    public Node flatten(Node a) {
        if (a == null) return null;
        Stack<Node> stack = new Stack<>();
        Node pri = new Node(-1);
        stack.push(a);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            pri.left = null;
            pri.right = node;
            pri = node;
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return a;
    }

}
