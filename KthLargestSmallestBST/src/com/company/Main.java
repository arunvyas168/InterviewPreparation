package com.company;

import javax.swing.*;

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


    public static Node addNodeBST(Node root, int data){
        if (root == null){
            return new Node(data);
        }

        if (root.data > data){
            root.left = addNodeBST(root.left,data);
        }else {
            root.right = addNodeBST(root.right,data);
        }
        return root;
    }

    public static void printInOrder(Node root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }



    public static void main(String[] args) {
        Node root = addNodeBST(null, 40);
        root = addNodeBST(root,20);
        root = addNodeBST(root,60);
        root = addNodeBST(root,10);
        root = addNodeBST(root,30);
        root = addNodeBST(root,70);
        root = addNodeBST(root,50);
        root = addNodeBST(root,25);
        printInOrder(root);
        System.out.println();
        kThLargestBST(root,3);
        kThSmallestBST(root,3);
    }

    /*
        Reverse inorder traversal of BST.
    */
    static int count = 0;
    public static void kThLargestBST(Node root, int k){
        if ((root == null)||(count>=k)){
            return;
        }

        kThLargestBST(root.right,k);
        count++;
        if(k == count){
            System.out.println("The k=3rd largest number in BST is: "+ root.data);
            return;
        }
        kThLargestBST(root.left,k);

    }
    /*
        Inorder traversal of BST.
    */
    static int count2 = 0;
    public static void kThSmallestBST(Node root, int k){
        if ((root == null)||(count2>=k)){
            return;
        }

        kThSmallestBST(root.left,k);
        count2++;
        if(k == count2){
            System.out.println("The k=3rd largest number in BST is: "+ root.data);
            return;
        }
        kThSmallestBST(root.right,k);

    }
}
