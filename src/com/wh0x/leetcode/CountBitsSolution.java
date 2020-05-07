package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/counting-bits/submissions/
 * leetcode 338
 */
public class CountBitsSolution {
    public int[] countBits(int num) {
        //解法1最低有效位
        int[] results = new int[num+1];
        for(int i = 1; i < results.length; i++){
            results[i] = results[i / 2] + i % 2;

        }
        return results;

    }
    public int[] countBitsII(int num) {
        //解法2 考虑x与x - 1
        int[] results = new int[num+1];
        for(int i = 1; i < results.length; i++){
            if(i % 2 == 0){
                //偶数
                results[i] = results[i >> 2];
            }else{
                //奇数
                results[i] = results[i - 1] + 1;
            }

        }
        return results;

    }
}
