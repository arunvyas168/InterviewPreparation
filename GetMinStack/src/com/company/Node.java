package com.company;

/**
 * Created by arun on 10/1/16.
 */
public class Node {
    int data;
    Node next;
    Node prev;
    public Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
