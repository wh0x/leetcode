package com.wh0x.leetcode.dp;

import java.util.List;

/*
 * leetcode 120
 * https://leetcode-cn.com/problems/triangle/
 * ToDo:空间优化以及自底向上
 */
public class MinimumTotalSolution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j = 1;j < i;j++) {
                dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}
