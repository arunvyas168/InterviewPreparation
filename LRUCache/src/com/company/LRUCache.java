package com.company;

import java.util.HashMap;

/**
 * Created by arun on 7/7/16.
 */
public class LRUCache {
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head;
    Node end;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public void remove(Node n){
        if(n.prev != null){
            n.prev.next = n.next;
        }else {
            head = n.next;
        }
        if (n.next != null){
            n.next.prev = n.prev;
        }else {
            end = n.prev;
        }
    }

    public void setHead(Node n){
        n.next = head;
        if(head!=null){
            head.prev = n;
        }
        head = n;
        if(end==null){
            end = head;
        }
    }


    public void set(int key, int value){
        if (map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else {
            Node created = new Node(key,value);
            if(map.size()>=this.capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            }else {
                setHead(created);
            }
            map.put(key,created);
        }
    }

    public int get(int key){
        if (map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }else {
            return -1;
        }
    }

}
