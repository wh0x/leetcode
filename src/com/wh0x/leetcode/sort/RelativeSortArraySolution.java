package com.wh0x.leetcode.sort;
/*
 * https://leetcode-cn.com/problems/relative-sort-array/
 * leetcode 1122
 * 思路1:用map，记录arr1中的元素及个数，然后按照arr2 遍历构造结果，对于剩下的元素进行排序然后加到结果中
 * 思路2：用计数排序，开辟额外数组，用value作为index,自动排序了，然后构造结果，注意所有value都在0到1000
 */
public class RelativeSortArraySolution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        int index = 0;
        for(int num : arr1){
            counts[num]++;
        }
        for(int num : arr2){
            while(counts[num] > 0){
                arr1[index++] = num;
                counts[num]--;
            }
        }
        for (int i = 0; i < 1001 ; i++) {
            if(counts[i] != 0){
                while(counts[i] > 0){
                    arr1[index++] = i;
                    counts[i]--;
                }
            }
        }
        return arr1;
    }
}
