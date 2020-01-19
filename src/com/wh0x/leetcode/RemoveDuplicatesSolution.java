package com.wh0x.leetcode;

public class RemoveDuplicatesSolution {
    /*
     * remove duplicates I
     */
    public int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j] != nums[i]){
                i ++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    /*
     *remove duplicates II
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
     */
    public int removeDuplicatesVersionII(int[] nums) {
        return 0;

    }
}
