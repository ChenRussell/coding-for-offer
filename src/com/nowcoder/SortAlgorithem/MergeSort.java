package com.nowcoder.SortAlgorithem;

/**
 * Created by ChenRui on 18-3-10
 */
public class MergeSort {

    public void merge(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) >> 1;
            merge(arr, low, middle);
            merge(arr, middle + 1, high);
            sort(arr, low, high);
        }
    }

    public void sort(int[] arr, int low, int high) {
        int left1 = low;
        int middle = (low + high) >> 1;
        int end1 = middle;
        int left2 = middle + 1;
        int end2 = high;
        int temp[] = new int[arr.length];
        int index = low;
        while (left1 <= end1 && left2 <= end2) {
            temp[index++] = arr[left1] < arr[left2] ? arr[left1++] : arr[left2++];
        }
        while (left1 <= end1) {
            temp[index++] = arr[left1++];
        }
        while (left2 <= end2) {
            temp[index++] = arr[left2++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 5, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(arr,0 ,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
