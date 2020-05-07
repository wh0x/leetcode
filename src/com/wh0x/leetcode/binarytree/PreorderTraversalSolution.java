package com.wh0x.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * leetcode 144
 * 思路1:递归,节点不为空添加到结果中，以左孩子为根前序，以右孩子为根前序
 * 思路2:用辅助栈模拟，添加根节点，出栈入栈，入栈时候先右后左
 */
public class PreorderTraversalSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }
    public void helper(TreeNode root,List<Integer> result){
        if(root == null)
            return;
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }
    //迭代
    public List<Integer> preorderTraversalII(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return result;
        stack.add(root);
        while(!stack.empty()){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return result;
    }

}
