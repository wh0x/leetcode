package com.wh0x.leetcode.string;
/*
 * 415
 * https://leetcode-cn.com/problems/add-strings/
 * 思路:模拟
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while(m >= 0 || n >= 0 || carry > 0){
            int a = m >= 0 ? num1.charAt(m) - '0' : 0;
            int b = n >= 0 ? num2.charAt(n) - '0' : 0;
            ans.append((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            m--;
            n--;
        }
        return ans.reverse().toString();

    }

}
