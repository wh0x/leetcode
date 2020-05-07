package com.wh0x.leetcode;

import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/path-sum/
 * leetcode 112
 */
public class HasPathSumSolution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //递归结束
        if(root == null)
            return false;
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0)
            return true;
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

    }
    public boolean hasPathSumII(TreeNode root,int sum){
        //迭代
        if(root == null)
            return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        while(!nodeStack.empty()){
            TreeNode currNode = nodeStack.pop();
            int currSum = sumStack.pop();
            if(currNode.left == null && currNode.right == null && currSum == 0)
                return true;
            if(currNode.left != null){
                nodeStack.add(currNode.left);
                sumStack.add(currSum - currNode.left.val);
            }
            if(currNode.right != null){
                nodeStack.add(currNode.right);
                sumStack.add(currSum - currNode.right.val);
            }
        }
        return false;
    }
}
