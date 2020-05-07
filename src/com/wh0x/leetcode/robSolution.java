package com.wh0x.leetcode;

import java.util.Arrays;

/*
 * leetcode 198 I
 * leetcode 213 II
 * leetcode 337 III
 */
public class robSolution {
    //dp[n] = max(dp[n-1],dp[n-2]+nums[n]) n取或者不取
    public int robI(int[] nums){
        if(nums == null)
            return 0;
        int prev = 0;
        int curr = 0;
        int tmp = 0;
        for(int num : nums){
            tmp = curr;
            curr = Math.max(prev + num,curr);
            prev = tmp;
        }
        return curr;
    }
    /*
     *环形 首尾相连
     * nums[0]不取 robI(nums[1:-1])
     * nums[0]取 nums[-1]就不能考虑 robI(nums[0:-2])
     */
    public int robII(int[] nums){
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        return Math.max(
                robI(Arrays.copyOfRange(nums,0,nums.length - 1)),
                robI(Arrays.copyOfRange(nums,1,nums.length))
                );

    }
    /*
     *树形dp
     * robInternal(root) 返回 一个数组 result[2],result[0] root 不取 result[1] root 取
     */
    public int robIII(TreeNode root){
        int[] result = robInternal(root);
        return Math.max(result[0],result[1]);
    }
    public int[] robInternal(TreeNode root){
        if(root == null)
            return new int[2];
        int[] result = new int[2];
        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
