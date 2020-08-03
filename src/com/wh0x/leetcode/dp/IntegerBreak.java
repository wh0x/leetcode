package com.wh0x.leetcode.dp;
/*
 * 343
 * https://leetcode-cn.com/problems/integer-break/
 * 思路：dp
 *
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 3;i <=n; i++){
            dp[i] = Integer.MIN_VALUE;
            for(int j = 1;j <= (i / 2);j++){
                int max = Math.max(j*(i-j),j*dp[i-j]);
                dp[i] = Math.max(dp[i],max);
            }
        }
        return dp[n];
    }
}
