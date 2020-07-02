package com.wh0x.leetcode.binarysearch;
/*
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * leetcode 378
 * 思路：二分查找
 */
public class KthSmallestSolution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0)
            return -1;
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        int mid = left + (right - left) / 2;
        while(left < right){
            //System.out.println(left+" "+right+" "+mid);
            if(helper(mid,matrix,k,n)){
                //小于或等于mid的数大于K,right=mid
                right = mid;
                //System.out.println("right");
            }else {
                //小于或等于mid的数 小于等于K
                left = mid + 1;
                //System.out.println("left");
            }
            mid = left + (right - left) / 2;
        }
        return left;
    }
    public boolean helper(int mid,int[][] matrix,int k,int n) {
        //计算小于或者等于mid的数的个数，从每一行的最右开始比较
        int i = 0;
        int j = n - 1;
        int count = 0;
        while(i < n && j >= 0){
            if(matrix[i][j] <= mid){
                count += (j+1);
                i++;
            }else {
                j--;
            }
        }
        return count >= k ? true:false;
    }
}
