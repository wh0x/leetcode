package com.wh0x.leetcode.sort;
/*
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * leetcode 922
 * 思路1：开辟额外数组加双指针，一次遍历
 * 思路2：双指针，奇指针不符合要求的找到第一个偶位置(不符合要求),交换
 */
public class SortArrayByParityIISolution {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        for (int i = 1; i < A.length ; i = i + 2) {
            if(A[i] % 2 == 0){
                while(A[even] % 2 == 0)
                    even += 2;
                int tmp = A[i];
                A[i] = A[even];
                A[even] = tmp;
            }

        }
        return A;
    }
}
