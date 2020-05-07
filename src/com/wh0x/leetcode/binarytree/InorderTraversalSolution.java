package com.wh0x.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * leetcode 94
 * 思路1:递归
 * 思路2:迭代
 */
public class InorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.empty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
