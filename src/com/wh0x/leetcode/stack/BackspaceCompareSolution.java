package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/backspace-string-compare/
 * leetcode 844
 */
public class BackspaceCompareSolution {
    public boolean backspaceCompare(String S, String T) {
        return backspaceString(S).equals(backspaceString(T));
    }

    public String backspaceString(String s){
        if(s == null)
            return null;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c != '#'){
                stack.push(c);
            }else{
                if(!stack.isEmpty())
                    stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
