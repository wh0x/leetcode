package com.wh0x.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * leetcode 145
 */
public class PostorderTraversalSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            TreeNode tmp = stack.pop();
            result.add(0,tmp.val);
            if(tmp.left != null){
                stack.push(tmp.left);
            }
            if(tmp.right != null){
                stack.push(tmp.right);
            }
        }
        return result;
    }
}
