package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/search-insert-position/
 * leetcode 35
 */
public class SearchInsertSolution {
    // Time:O(n)
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] >= target)
                return i;
        }
        return nums.length;

    }
    // 二分查找最好
}
