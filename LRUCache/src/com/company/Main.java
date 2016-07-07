package com.company;

/*
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

set(key, value) - Set or insert the value if the key is not already present.
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/




public class Main {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(5);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.set(5,5);
        System.out.println(cache.get(1));
        cache.set(6,6);
        System.out.println(cache.get(2)); // should return -1
    }
}
