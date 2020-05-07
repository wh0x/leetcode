package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * leetcode 150
 * 思路：数字入栈，遇到操作符出栈计算结果入栈
 * Time:O(n)
 * Space:O(n)
 */
public class EvalRPNSolution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            }else{
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
