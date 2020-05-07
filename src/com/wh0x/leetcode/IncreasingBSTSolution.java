package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * leetcode 897
 */
public class IncreasingBSTSolution {
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return root;
        inorder(root);
        return dummy.right;
    }
    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        root.left = null;
        prev.right = root;
        prev = root;
        inorder(root.right);

    }

}
