package top.yuifans.sort;

public class MergeSort {
    // 归并排序
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    // 递归分治
    private static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    // 合并两个有序数组
    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0, l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            temp[i++] = array[l] < array[r] ? array[l++] : array[r++];
        }
        while (l <= mid) {
            temp[i++] = array[l++];
        }
        while (r <= right) {
            temp[i++] = array[r++];
        }
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}

