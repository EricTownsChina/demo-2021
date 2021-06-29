package algorithm.algo;

/**
 * @author Eric 18358572500
 * company: fh
 * time: 2021/3/30 8:31
 * desc: 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 6, 6, 7, 9};
//        System.out.println(binSearch(arr, 6));

        System.out.println(binSearch5(arr, 6));

    }

    private static int binSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            //中间位置
            mid = (lo + hi) / 2;
            if (array[mid] == a) {
                return mid + 1;
                //向右查找
            } else if (array[mid] < a) {
                lo = mid + 1;
                //向左查找
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    private static int binSearch2(int[] arr, int b) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == b) {
                return mid + 1;
            } else if (arr[mid] < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int binSearch3(int[] arr, int dst) {
        int low = 0;
        int high = arr.length;
        int mid;
        //循环终止条件: 低位大于高位了, 说明无法再分了
        while (low <= high) {
            mid = (low + high) / 2;
            if (dst == arr[mid]) {
                return mid + 1;
            } else if (dst < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binSearch4(int[] arr, int dst) {
        int low = 0;
        int high = arr.length;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (dst == arr[mid]) {
                return mid + 1;
            } else if (dst < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binSearch5(int[] arr, int dst) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] == dst) {
                return mid + 1;
            } else if (dst < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binSearch6(int[] arr, int dst) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;
            if (dst == arr[mid]) {
                return mid + 1;
            } else if (dst < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binSearch7(int[] arr, int dst) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == dst) {
                return mid + 1;
            } else if (arr[mid] < dst) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

}
