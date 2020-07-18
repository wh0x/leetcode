package com.wh0x.leetcode.binarysearch;
/*
 * 35
 * https://leetcode-cn.com/problems/search-insert-position/
 * 思路：二分查找
 */
public class SearchInsertSolution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2 ;
            System.out.println(mid);
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
