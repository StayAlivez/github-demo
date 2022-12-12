package top.yuifans.sort;

public class HeapSort {
    // 堆排序
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 构建大根堆
        for (int i = 0; i < array.length; i++) {
            heapInsert(array, i);
        }
        int heapSize = array.length;
        swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }
    }

    // 构建大根堆
    private static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 堆化
    private static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && array[left + 1] > array[left]
                    ? left + 1
                    : left;
            largest = array[largest] > array[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(array, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 交换数组中两个位置的元素
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

