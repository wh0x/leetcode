package com.wh0x.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        this.top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            this.top = q1.remove();
            q2.add(top);
        }
        int p = q1.remove();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return p;
    }

    /** Get the top element. */
    public int top() {
        return this.top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
