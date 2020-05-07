package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * leetcode 232
 * 思路：
 * Time:
 * Space:
 */
public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;
    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.empty()){
            front = x;
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!s2.isEmpty())
            return s2.pop();
        else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()){
            return s2.peek();
        }else {
            return this.front;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
