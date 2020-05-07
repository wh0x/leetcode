package com.wh0x.leetcode.stack;
/*
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 * leetcode 1021
 * 思路:‘(’ + 1 ‘)’ -1，栈为空代表找到一个原语，这时删除掉最外边的括号并添加到结果中,strat原语起始位置
 * flag 代表是否开启原语，用于更新start的位置
 * Time:O(n)
 * Space:O(1)
 */
public class RemoveOuterParenthesesSolution {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int start = 0;
        boolean flag = false;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '('){
                count++;
                if(!flag){
                    start = i;
                    flag = true;
                }
            }else{
                count--;
            }
            if(count == 0){
                result.append(S.substring(start+1,i));
                //重置原语起始
                flag = false;
            }

        }
        return result.toString();
    }
}
