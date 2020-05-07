package com.wh0x.leetcode;

import java.util.HashMap;

/*
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * leetcode 167
 */
public class TwoSumIISolution {
    public int[] twoSum(int[] numbers, int target) {
        /* 暴力 hashmap 都没有利用数组有序的特点
         * 双指针
         */
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target)
                return new int[]{low+1,high+1};
            else{
                if(sum < target)
                    low++;
                else
                    high--;
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSumByHashMap(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < numbers.length;i++){
            map.put(numbers[i],i);
        }
        for(int i = 0;i < numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                return new int[] {i+1,map.get(target - numbers[i])+1};
            }
        }
        return new int[] {-1,-1};
    }
}
