package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/target-sum/
 * leetcode 494
 */
public class FindTargetSumWaysSolution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {

        help(0,nums,0,S);
        return count;

    }
    private void help(int ind,int[] nums,int sum,int S){
        if(ind == nums.length){
            if(sum == S)
                count++;
        }else{
            help(ind+1,nums,sum + nums[ind],S);
            help(ind+1,nums,sum - nums[ind],S);
        }
    }
}
