package com.wh0x.leetcode.recursion;

import com.wh0x.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
 *95
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 思路：1.递归
 *      2.dp TODO
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }
        return helper(1,n);
    }
    public List<TreeNode> helper(int low,int high) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        if(low == high){
            ans.add(new TreeNode(low));
            return ans;
        }
        if(low > high){
            ans.add(null);
            return ans;
        }
        for (int i = low; i <= high ; i++) {
            List<TreeNode> leftList = helper(low,i-1);
            List<TreeNode> rightList = helper(i+1,high);
            for(TreeNode left : leftList){
                for(TreeNode right : rightList){
                    //System.out.println(i);
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
