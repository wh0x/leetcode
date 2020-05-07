package com.wh0x.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode-cn.com/problems/symmetric-tree/
 * leetcode 101
 */
public class IsSymmetricSolution {
    //递归解法，辅助函数：两棵树是否是镜像的
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirrow(root.left,root.right);

    }
    public boolean isMirrow(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.val != t2.val)
            return false;
        return isMirrow(t1.left,t2.right) && isMirrow(t1.right,t2.left);
    }
    //迭代解法，判断一棵树是否为对称的只需要证明 该棵树和他的复制是否是镜像的
    public boolean isSmmetricII(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if(t1 == null && t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
