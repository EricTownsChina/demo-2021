package algorithm.algo;

/**
 * @author Eric 18358572500
 * company: fh
 * time: 2021/3/30 15:48
 * desc: 快速排序
 *
 * 时间复杂度 : O(N*logN)
 *
 * 1．先从数列中取出一个数作为基准数。
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 44, 76, 22, 1};

        quickSort6(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = s[l];

            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] >= x) {
                    j--;
                }
                if (i < j) {
                    s[i] = s[j];
                    i++;
                }

                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                if (i < j) {
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;

            // 递归调用
            quickSort(s, l, i - 1);
            quickSort(s, i + 1, r);
        }
    }

    private static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            //按照第一个元素来分治
            int x = arr[left];
            while (i < j) {
                while (i < j && arr[j] >= x) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }

                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = x;

            quickSort2(arr, left, i - 1);
            quickSort2(arr, i + 1, right);
        }
    }

    private static void quickSort3(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int val = arr[left];

            while (i < j) {
                while (i < j && arr[j] >= val) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < val) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = val;

            quickSort3(arr, left, i - 1);
            quickSort3(arr, i + 1, right);
        }
    }

    private static void quickSort4(int[] arr, int left, int right) {
        if (left < right) {
            //第一次的分治法
            int i = left;
            int j = right;
            //分治的标杆
            int val = arr[left];

            while (i < j) {
                while (i < j && arr[j] >= val) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < val) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = val;

            //递归进行分治
            quickSort4(arr, left, i - 1);
            quickSort4(arr, i + 1, right);
        }
    }

    private static void quickSort5(int[] arr, int left, int right) {
        if (left < right) {
            //分治法
            int i = left;
            int j = right;
            int val = arr[left];
            while (i < j) {
                while (i < j && val < arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < val) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = val;
            quickSort5(arr, left, i - 1);
            quickSort5(arr, i + 1, right);

        }
    }

    private static void quickSort6(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int val = arr[i];

            while (i < j) {
                while (i < j && val <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && val > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = val;

            quickSort6(arr, left, i - 1);
            quickSort6(arr, i + 1, right);
        }
    }

    private static void quickSort7(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int val = arr[i];

            while (i < j) {
                while (i < j && val <= arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && val > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = val;
            quickSort7(arr, left, i - 1);
            quickSort7(arr, i + 1, right);
        }
    }
}
