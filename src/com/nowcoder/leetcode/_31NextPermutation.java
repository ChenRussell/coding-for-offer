package com.nowcoder.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * mplement next permutation, which rearranges numbers into the lexicographically next
 * greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs
 * are in the right-hand column.
 * <p>
 * 1,2,3 �� 1,3,2
 * 3,2,1 �� 1,2,3
 * 1,1,5 �� 1,5,1
 */
public class _31NextPermutation {

    public void nextPermutation(int[] nums) {

        boolean flag = false;
        int i = nums.length-2;
        while (i >= 0) {
            if (nums[i] < nums[i+1]) {
                flag = true;
                break;
            }
            i--;
        }
        int j = nums.length - 1;
        while (flag && j > i) {
            if (nums[j] > nums[i]) break;
            j--;
        }
        if (i>=0) {
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
        }
        if (!flag) {
            reverse(nums, 0, nums.length-1);
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation2(int arr[]) {
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = arr.length-1; j > i; j--) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                    Arrays.sort(arr, i + 1, arr.length);
                    return;
                }
            }
        }
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        _31NextPermutation nextPermutation = new _31NextPermutation();
        int[] arr = {1, 3, 2, 1};
        nextPermutation.nextPermutation2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
