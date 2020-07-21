package com.wh0x.leetcode;

/*
 * 167
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 思路：双指针
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int low = 0;
        int high = n - 1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) {
                return new int[]{low+1,high+1};
            }
            if(sum > target)
                high--;
            if(sum < target)
                low++;
        }
        return new int[]{-1,-1};
    }
}
