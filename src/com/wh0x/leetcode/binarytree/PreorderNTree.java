package com.wh0x.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderNTree {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        //迭代
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            Node curr = stack.pop();
            result.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0 ; i--) {
                Node next = curr.children.get(i);
                if(next != null)
                    stack.push(next);
            }
        }
        return result;
    }
}
