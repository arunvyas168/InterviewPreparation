package com.company;

/**
 * Created by arun on 10/1/16.
 */
public class MiddleStack {
    private Node head;
    private Node middle;
    private static int size;

    public MiddleStack(){
        this.head = null;
        this.middle = null;
    }

    public void push(int data){
        size++;
        if(head == null){
            head = new Node(data);
            middle = head;
        }else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        if(size%2==0){
            middle = middle.prev;
        }
    }

    public int pop(){
        if (head == null){
            return -1;
        }
        size--;
        Node current = head;
        if (head.next!=null){
            head = head.next;
            if (size%2==1){
                middle = middle.next;
            }
        }else {
            head = null;
            middle = null;
        }
        return current.data;
    }

    public int getMid(){
        if (head==null){
            return -1;
        }else {
            return middle.data;
        }
    }

    public void deleteMid() {
        if (size<=1){
            head = null;
            middle = null;
            size = 0;
            return;
        }
        size--;
        Node ret = null;
        if(middle.prev!=null) {
            if(size%2==0) {
                ret = middle.prev;
            }
            middle.prev.next=middle.next;
        }
        if(middle.next!=null) {
            if(size%2==1) {
                ret = middle.next;
            }
            middle.next.prev=middle.prev;
        }
        middle = ret;
    }

}
