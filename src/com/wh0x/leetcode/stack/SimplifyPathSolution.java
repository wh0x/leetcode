package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/simplify-path/
 * leetcode 71
 * 思路:以"/"分割字符串，"." ".." "" "正常路径"，正常路径入栈，".."出栈
 * Time:O(n)
 * Space:O(n)
 */
public class SimplifyPathSolution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(String s : path.split("/")){
            if(s.equals("..") && !stack.empty()){
                stack.pop();
            }else if(!s.equals(".") && !s.equals("") && !s.equals("..")){
                stack.push(s);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/"+stack.get(i));
        }
        return sb.length() == 0 ? "/" : new String(sb);

    }
}
