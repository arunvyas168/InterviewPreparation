package com.company;

public class Main {

    public static void main(String[] args) {
        Node n1 = new Node(30);

        Node n2 = new Node(20);
        n1.left = n2;

        Node n3 = new Node(40);
        n1.right = n3;

        Node n4 = new Node(10);
        n2.left = n4;

        Node n5 = new Node(25);
        n2.right = n5;

        Node n6 = new Node(35);
        n3.left = n6;

        Node n7 = new Node(45);
        n3.right = n7;

        BinaryTree tree = new BinaryTree();
        tree.printInOrder(n1);
        /*System.out.println();
        tree.binaryTreeToDoubleList(n1);*/
        //tree.printList();
        Node head = tree.flatten(n1);
        printList(head);
        System.out.println();
    }
    public static void printList(Node head){
        Node current = head;
        while (current!=null){
            System.out.print(current.data+" ");
            current = current.right;
        }
    }
}
