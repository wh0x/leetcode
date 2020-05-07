package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * leetcode 5
 * 1.暴力
 * 2.dp
 * 3.中心扩展法
 */
public class LongestPalindromesolution {
    public String longestPalindrome(String s) {
        /*
         * dp[i][j] = dp[i+1][j-1] && (s[i] = s[j])
         * dp[i][i] = True
         * dp[i][j] = s[i] == s[j] j = i + 1
         */
        if(s == null || s.length() <= 1){
            return s;
        }
        int length = s.length();
        int maxLength = 1;
        int begin = 0;
        String result = "";
        boolean[][] dp = new boolean[length][length];
        for(int i = 0; i < length; i++){
            dp[i][i] = true;
        }

        for(int j = 1;j < length;j++){
            for(int i = 0;i < j;i++){
                if(s.charAt(i) == s.charAt(j) && (j - i) < 2)
                    dp[i][j] = true;
                if(s.charAt(i) == s.charAt(j) && (j - i) >= 2)
                    dp[i][j] = dp[i+1][j-1];
                if(s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;

                if(dp[i][j]) {
                    if((j - i + 1) > maxLength){
                        maxLength = j - i + 1;
                        begin = i;
                    }
                }

            }
        }
        result = s.substring(begin,begin + maxLength);
        return result;

    }
}
