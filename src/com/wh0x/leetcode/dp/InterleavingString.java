package com.wh0x.leetcode.dp;

/*
 * 97
 * https://leetcode-cn.com/problems/interleaving-string/\
 * 思路：dp[i][j] 代表 s1前i个字符 s2 前j个字符 能否交错构成s3前（i+j）个字符
 * 状态转移方程：
 * dp[i][j] = false s3[i+j-1] != s1[i-1] && s3[i+j-1] != s2[j-1
 *             (dp[i-1][j] && s3[i+j-1] == s1[i-1]) ||  (dp[i][j-1] && s3[i+j-1] == s2[j-1])
 * 初始： dp[0][0] = true
 *       dp[0][j]
 *       dp[i][0]
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if((m + n) != s3.length())
            return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <= n && s2.charAt(j-1) == s3.charAt(j-1); j++) {
            dp[0][j] = true;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(s3.charAt(i+j-1) != s1.charAt(i-1) && s3.charAt(i+j-1) != s2.charAt(j-1)){
                    dp[i][j] = false;
                }else {
                    dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) || (dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
                }
            }
        }
        return dp[m][n];
    }
}
