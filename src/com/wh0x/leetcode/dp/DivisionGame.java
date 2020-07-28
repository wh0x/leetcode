package com.wh0x.leetcode.dp;

/*
 * 1025]
 * https://leetcode-cn.com/problems/divisor-game/
 * 思路:1 归纳法 判断奇偶
 *      2 dp,dp[i]代表先手且当前数为i的结果，dp[1] = flase,dp[2] = true
 */
public class DivisionGame {
    public boolean divisorGame(int N) {
        if(N == 1)
            return false;
        if(N == 2)
            return true;
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <i; j++) {
                if(i % j == 0 && dp[i-j] == false) {
                    dp[i] = true;
                }
            }
        }
        return dp[N];
    }
}
