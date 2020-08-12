package com.wh0x.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author george
 * @Date 2020/8/12 23:56
 * @Version 1.0
 */

/**
 * 133
 * https://leetcode-cn.com/problems/clone-graph/
 * 思路:克隆图，则首先得遍历图，用dfs或者bfs,同时得记录节点是否访问过，避免重复访问死循环
 */
public class cConeGraph {
    public Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();//存放原节点以及对应拷贝节点的映射
        return dfs(node,map);
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if(node == null)
            return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val,new ArrayList<>());
        map.put(node,clone);
        for(Node neighbor : node.neighbors){
            clone.neighbors.add(dfs(neighbor,map));
        }
        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
