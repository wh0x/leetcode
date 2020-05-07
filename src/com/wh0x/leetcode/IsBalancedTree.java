package com.wh0x.leetcode;

/*
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * leetcode 110
 */
public class IsBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftTreeDepth = getTreeDepth(root.left);
        int rightTreeDepth = getTreeDepth(root.right);
        if(Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }
    public int getTreeDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getTreeDepth(root.left),getTreeDepth(root.right)) + 1;
    }
    //自底向上
    public boolean isBalancedTree(TreeNode root){
        return depth(root) != -1;
    }
    public int depth(TreeNode root){
        //以root为根节点，如果左右高度不超过1返回高度，否则返回-1，代表不是平衡二叉树
        if(root == null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == -1)
            return -1;
        if(rightDepth == -1)
            return -1;
        return Math.abs(leftDepth - rightDepth) < 2 ? Math.max(leftDepth,rightDepth) + 1 : -1;
    }
}
