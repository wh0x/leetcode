package com.wh0x.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * leetcode 102
 * 思路:用队列，先将根节点加入队列，每次出队的时候一次性将队列中一开始有的元素全出队，
 * 出队的同时入队形成下一层
 * Time:O(n)
 * Space:O(n)
 */
public class LevelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> currLevel = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmp = queue.remove();
                currLevel.add(tmp.val);
                if(tmp.left != null)
                    queue.add(tmp.left);
                if(tmp.right != null)
                    queue.add(tmp.right);
            }
            result.add(currLevel);
        }
        return result;
    }
}
