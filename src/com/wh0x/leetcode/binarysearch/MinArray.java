package com.wh0x.leetcode.binarysearch;
/*
 * 11
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * 思路：暴力 TODO:二分，因为有序
 */
public class MinArray {
    public int minArray(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return -1;
        }
        for(int i = 1;i < numbers.length;i++){
            if(numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
