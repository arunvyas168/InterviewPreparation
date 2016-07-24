package com.company;

import java.util.Stack;

public class Main {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node addNodeToBST(Node root, int data){
        if (root==null){
            return new Node(data);
        }
        if (data<root.data){
            root.left = addNodeToBST(root.left,data);
        } else {
            root.right = addNodeToBST(root.right,data);
        }
        return root;
    }


    public static void main(String[] args) {
        Node root = null;
        root = addNodeToBST(root,40);
        root = addNodeToBST(root,20);
        root = addNodeToBST(root,60);
        root = addNodeToBST(root,50);
        root = addNodeToBST(root,70);
        root = addNodeToBST(root,10);
        root = addNodeToBST(root,30);
        root = addNodeToBST(root,25);
        System.out.println(isPairWithSum(root,75));

    }

    /**
     *  Problem1:   Find a pair with given sum in a Balanced BST
     *  http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
     */
    public static boolean isPairWithSum(Node root, int sum){
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        boolean done1 = true;
        boolean done2 = true;
        int val1 = 0;
        int val2 = 0;
        Node current1 = root;
        Node current2 = root;

        while (true){
            while (done1){
                if (current1!=null){
                    st1.push(current1);
                    current1 = current1.left;
                }else {
                    if (st1.empty()){
                        done1 = false;
                    }else {
                        current1 = st1.pop();
                        val1 = current1.data;
                        current1 = current1.right;
                        done1 = false;
                    }
                }
            }

            while (done2){
                if (current2!=null){
                    st2.push(current2);
                    current2 = current2.right;
                }else {
                    if(st2.empty()){
                        done2 = false;
                    }else {
                        current2 = st2.pop();
                        val2 = current2.data;
                        current2 = current2.left;
                        done2=false;
                    }
                }
            }

            if ((val1!=val2)&&(val1+val2 == sum)){
                return true;
            }else if (val1+val2 <sum){
                done1 = true;
            }else if (val1+val2 >sum){
                done2 = true;
            }
            if (val1 >= val2)
                return false;

        }
    }


    /**
     *  Problem2:   Find distance between two given keys of a Binary Tree
     *  http://www.geeksforgeeks.org/find-distance-two-given-nodes/
     *  Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca);
     */




}
