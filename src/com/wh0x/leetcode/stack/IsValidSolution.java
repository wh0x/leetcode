package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/valid-parentheses/
 * leetcode 20
 */
public class IsValidSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(c == ')'){
                    if(stack.isEmpty() || stack.peek() != '(')
                        return false;
                    else
                        stack.pop();
                }
                if(c == ']'){
                    if(stack.isEmpty() || stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                }
                if(c == '}'){
                    if(stack.isEmpty() || stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
