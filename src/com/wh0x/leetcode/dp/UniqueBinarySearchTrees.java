package com.wh0x.leetcode.dp;

/*
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * leetcode 96
 * 思路：dp，以i作为根，能够得到的不同二叉搜索树为 f(i)
 * 则n个数能够得到的不同二叉搜索树 g(n) = sum(f(i)) i = 1,2,3 ... n
 * 以i为根，则左子树由[1,2,3 .. i -1]构成，同理 右子树 [i+1,i+2, .. n]则有
 * f(i) = g(i-1) * g(n-i)
 * g(n) = sum(g(i-1)*g(n-i)) i = 1,2,3, ... n
 * 初始条件
 *         g(1) = 1
 *         g(0) = 1
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n <= 1)
            return 1;
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2;i <= n;i++) {
            for(int j = 1;j <= i;j++) {
                g[i] += (g[j-1]*g[i-j]);
            }
        }
        return g[n];
    }
}
