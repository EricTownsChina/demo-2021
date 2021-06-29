package algorithm.algo;

/**
 * @author Eric 18358572500
 * company: fh
 * time: 2021/3/31 9:14
 * desc: 希尔排序  是插入排序的一种
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 44, 76, 22, 1};

        shellSort5(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void shellSort2(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }

    private static void shellSort(int[] a) {
        int dk = a.length / 2;
        while (dk >= 1) {
            shellInsertSort(a, dk);
            dk = dk / 2;
        }
    }

    private static void shellInsertSort(int[] a, int dk) {
        // 类似插入排序, 只是插入排序增量是1, 这里增量是dk, 把1换成dk就可以了
        for (int i = dk; i < a.length; i++) {
            if (a[i] < a[i - dk]) {
                int j;
                // x 为待插入元素
                int x = a[i];
                a[i] = a[i - dk];
                for (j = i - dk; j >= 0 && x < a[j]; j = j - dk) {
                    // 通过循环, 逐个后移一位找到要插入的位置.
                    a[j + dk] = a[j];
                }
                // 插入
                a[j + dk] = x;
            }
        }
    }

    private static void shellSort3(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 1) {
            shellInsertSort2(arr, dk);
            dk = dk / 2;
        }
    }

    private static void shellInsertSort2(int[] arr, int dk) {
        //dk 是步长
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int val = arr[i];
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && val < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                //插入
                arr[j + dk] = val;
            }
        }
    }

    private static void shellSort4(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 0) {
            //
            dk /= 2;
        }
    }

    private static void shellInsertSort4(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int val = arr[i];
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && val < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = val;
            }
        }
    }

    private static void shellSort5(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 1) {
            //
            shellInsertSort5(arr, dk);
            dk /= 2;
        }
    }

    private static void shellInsertSort5(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int val = arr[i];
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && val < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = val;
            }
        }
    }

    private static void shellSort6(int[] arr) {
        int dk = arr.length / 2;
        while (dk >= 1) {
            //
            shellInsertSort6(arr, dk);
            dk /= 2;
        }
    }

    private static void shellInsertSort6(int[] arr, int dk) {
        for (int i = dk; i < arr.length; i++) {
            if (arr[i] < arr[i - dk]) {
                int j;
                int val = arr[i];
                arr[i] = arr[i - dk];
                for (j = i - dk; j >= 0 && val < arr[j]; j -= dk) {
                    arr[j + dk] = arr[j];
                }
                arr[j + dk] = val;
            }
        }
    }

}
