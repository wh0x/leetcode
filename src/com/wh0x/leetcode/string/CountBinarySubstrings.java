package com.wh0x.leetcode.string;

/**
 * @Author Wang Hao
 * @Date 2020/8/10 23:45
 * @Version 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 696
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * 思路：计算连续 0 或者 1 的个数，然后取相邻count中的最小值
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        //统计连续数字的个数
        //TODO:换一个更优雅的写法
        if(s.length() == 1){
            return 0;
        }
        int ans = 0;
        int len = s.length();
        List<Integer> counts = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                counts.add(count);
                count = 1;
            }
        }
        if(s.charAt(len - 1) != s.charAt(len - 2)){
            counts.add(1);
        }else{
            counts.add(count);
        }
        //print list
        //for (int i = 0; i < counts.size(); i++) {
        //    System.out.println(counts.get(i));
        //}
        for (int i = 0; i < counts.size() - 1; i++) {
            ans += Math.min(counts.get(i),counts.get(i+1));
        }
        return ans;
    }
}
