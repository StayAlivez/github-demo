package top.yuifans.sort;

import java.util.Arrays;
import java.util.Random;

public class ShortDemo {
    public static void main(String[] args) {
        int[] arr = new int[100000];

        Random r = new Random();

        // 使用随机数生成器生成 1000000 个随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }

        // 记录排序开始时间
        long start = System.currentTimeMillis();

        // 对数组 arr 进行 排序

        // 堆排序
        // HeapSort.heapSort(arr);
        // 快速排序
        // QuickSort.quickSort(arr);
        // 归并排序
        // MergeSort.mergeSort(arr);

        // Arrays.sort 排序
        Arrays.sort(arr);

        // 记录排序完成时间
        long end = System.currentTimeMillis();

        // 计算排序用时，并输出到控制台
        System.out.println("用时" + (end - start) + "ms");
    }
}
