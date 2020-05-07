package com.wh0x.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * leetcode 103
 * 思路:层次遍历，设flag,利用linklist方便从头插入元素
 * Time:O(n)
 * Space:O(n)
 */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                if(flag){
                    temp.add(curr.val);
                }else{
                    temp.addFirst(curr.val);
                }
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
            result.add(temp);
            flag = !flag;
        }
        return result;
    }
}
