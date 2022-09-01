package com.sudhir;

import java.util.*;

/*
* Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

* The functions get and put must each run in O(1) average time complexity.
* */
public class LRU {
    int capacity;
    public LRU(int capacity) {
        this.capacity = capacity;
    }

    static Map<Integer, Integer> lru = new LinkedHashMap<Integer, Integer>();
    public static void main(String[] args) {
        LRU obj = new LRU(5);
        obj.put(10, 10);
        System.out.println(lru.toString());
        obj.put(12, 12);
        System.out.println(lru.toString());
        obj.put(13, 13);
        System.out.println(lru.toString());
        obj.put(14, 14);
        System.out.println(lru.toString());
        obj.put(15, 15);
        System.out.println(lru.toString());
        obj.put(9, 9);
        System.out.println(lru.toString());

        System.out.println(obj.get(12));
        System.out.println(lru.toString());

        System.out.println(obj.get(1200));
        System.out.println(lru.toString());

        System.out.println(obj.get(13));
        System.out.println(lru.toString());

        obj.put(78, 78);
        System.out.println(lru.toString());

        obj.put(58, 58);
        System.out.println(lru.toString());

        System.out.println(obj.get(13));
        System.out.println(lru.toString());

        System.out.println(obj.get(58));
        System.out.println(lru.toString());
    }
    public int get(int key) {
        if(lru.containsKey(key)) {
            makeRecently(key);
            return lru.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (lru.containsKey(key)){
            lru.put(key, value);
            makeRecently(key);
        }else{
            if(lru.size() >= capacity){
                Integer oldestKey = lru.keySet().iterator().next();
                lru.remove(oldestKey);
            }
            lru.put(key, value);
        }
    }

    private void makeRecently(int key) {
        Integer value = lru.get(key);
        lru.remove(key);
        lru.put(key, value);
    }
}
