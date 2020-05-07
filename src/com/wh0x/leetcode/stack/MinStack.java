package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/min-stack/
 * leetcode 155
 * 思路1；保存最小值，但问题是当最小值弹出之后怎么得到新的最小值呢，因此最好在新的最小值
 * 入栈的时候将之前的最小值也入栈，出栈的时候如果出栈的是最小元素要将次小元素也出栈，这时候可以得到新的
 * 最小值
 * Time:O(1)
 * Space:O(1)
 * 思路2：利用一个辅助栈，栈顶保存最小值
 */
public class MinStack {
    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
            stack.push(x);
        }else{
            stack.push(x);
        }
    }

    public void pop() {
        if(stack.pop() == min){
            //弹出两次
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
