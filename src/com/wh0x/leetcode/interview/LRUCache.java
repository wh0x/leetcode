package com.wh0x.leetcode.interview;

import java.util.HashMap;

/*
 * https://leetcode-cn.com/problems/lru-cache/
 * leetcode 146
 * 思路:hashmap + Dlinkedlist
 */
public class LRUCache {
    private int capacity;
    private int count;
    private HashMap<Integer,DLinkedList> cache;
    private DLinkedList head;
    private DLinkedList tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new DLinkedList(-1,-1);
        tail = new DLinkedList(-1,-1);
        head.post = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            //return and move the node to head;
            DLinkedList node = cache.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            //update value
            cache.get(key).value = value;
            //move to head
            DLinkedList node = cache.get(key);
            remove(node);
            addToHead(node);
        }else{
            //create a new node and move to head,then check the capacity
            DLinkedList newNode = new DLinkedList(key,value);
            addToHead(newNode);
            cache.put(key,newNode);
            count++;
            //if count larger than capacity,should remove tail node
            if(count > capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
                count--;
            }

        }

    }

    private void addToHead(DLinkedList node){
        //add to head
        node.post = head.post;
        node.prev = head;
        head.post.prev = node;
        head.post = node;
    }
    private void remove(DLinkedList node){
        //remove form linklist
        node.prev.post = node.post;
        node.post.prev = node.prev;
    }


    private class DLinkedList{
        int key;
        int value;
        DLinkedList prev;
        DLinkedList post;

        DLinkedList(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}
