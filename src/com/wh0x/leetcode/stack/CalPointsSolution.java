package com.wh0x.leetcode.stack;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/baseball-game/
 * leetcode 682
 * 思路：
 * Time:
 * Space:
 */
public class CalPointsSolution {
    public int calPoints(String[] ops) {
        int sumPoints = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if(ops[i].equals("+")){
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                sumPoints += newTop;
            }else if(ops[i].equals("D")){
                stack.push(stack.peek() * 2);
                sumPoints += stack.peek();
            }else if(ops[i].equals("C")){
                sumPoints -= stack.peek();
                stack.pop();
            }else{
                stack.push(Integer.valueOf(ops[i]));
                sumPoints += Integer.valueOf(ops[i]);
            }
        }
        return sumPoints;
    }
}
