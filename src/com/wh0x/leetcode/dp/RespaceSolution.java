package com.wh0x.leetcode.dp;
/*
 * https://leetcode-cn.com/problems/re-space-lcci/
 * 思路：dp[i]为子串str(0,i)不包括i,最大识别的字符数，第i-1个字符是否进行匹配，是否找到一个
 * word刚好匹配了(i - word.length() - 2,i)
 * 转移方程：
 * dp[i] = dp[i-1] Not
 *         max(dp[i-word.length()-2] + word.length()) 所有匹配到的word都需要检查 Yes
 */
public class RespaceSolution {
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            for(String word : dictionary) {
                if(i - word.length() >= 0 && word.equals(sentence.substring(i - word.length(),i))){
                    dp[i] = Math.max(dp[i],dp[i - word.length()] + word.length());
                }
            }
        }
        return n - dp[n];
    }
}



