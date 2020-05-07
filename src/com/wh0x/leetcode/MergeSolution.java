package com.wh0x.leetcode;
/*
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * leetcode 88
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 */
public class MergeSolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int q = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            nums1[q--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2,0,nums1,0,p2 + 1);

    }
}
