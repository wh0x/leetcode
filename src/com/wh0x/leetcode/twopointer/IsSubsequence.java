package com.wh0x.leetcode.twopointer;

/*
 * 392
 * https://leetcode-cn.com/problems/is-subsequence/
 * 思路：双指针 TODO:dp解法
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            while(j < n && s.charAt(i) != t.charAt(j)){ //注意边界,先判断j < n
                j++;
            }
            if(j < n){ //注意可能是没有找到相等的跳出循环，因此必须检查j是否出界，再决定是否被向前移
                i++;
                j++;
            }
        }
        return i > (m-1) ? true : false;
    }
}
