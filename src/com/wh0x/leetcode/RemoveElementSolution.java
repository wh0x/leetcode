package com.wh0x.leetcode;

public class RemoveElementSolution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int curr = 0;
        for(int ind = 0;ind < nums.length;ind++){
            if(nums[ind] != val) {
                nums[curr] = nums[ind];
                curr ++;
            }
        }
        return curr;
    }
}
