package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * leetcode 111
 */
public class MinDepthSolution {
    public int minDepth(TreeNode root) {
        //递归
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }
        if(root.left == null && root.right != null)
            return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;

    }
}
