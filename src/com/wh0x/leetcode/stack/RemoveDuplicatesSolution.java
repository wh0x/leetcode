package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * leetcode 1047
 */
public class RemoveDuplicatesSolution {
    //直接用栈或者用数组模拟栈
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length() ; i++) {
            if(stack.isEmpty() || S.charAt(i) != stack.peek()){
                stack.push(S.charAt(i));
            }else{
                stack.pop();
            }
        }
        for(char c : stack){
            sb.append(c);
        }
        return new String(sb);

    }
}
