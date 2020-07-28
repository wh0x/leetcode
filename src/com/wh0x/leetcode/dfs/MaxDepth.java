package com.wh0x.leetcode.dfs;

import com.wh0x.leetcode.TreeNode;

/*
 * 104
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 思路：dfs TODO:bfs
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
}
