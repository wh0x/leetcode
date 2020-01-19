package com.wh0x.leetcode;

public class MinSubArrayLenSolution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int result = nums.length + 1;
        int sum = 0;
        while(right < nums.length){
            if(sum + nums[right] < s){
                sum += nums[right];
                right ++;
            }else{
                result = (right - left + 1) < result ? (right - left + 1):result;
                sum -= nums[left];
                left ++;
            }

        }
        return result < (nums.length + 1) ? result:0;
    }
}
