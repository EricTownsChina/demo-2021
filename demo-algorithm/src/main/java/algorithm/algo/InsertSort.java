package algorithm.algo;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/29 16:46
 * <p>
 * Desc: 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 44, 76, 22, 1};
        insertSort8(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //插入的数
            int insertVal = arr[i];
            //被插入的位置(准备和前一个数比较)
            int index = i - 1;
            //如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
                //将把arr[index] 向后移动
                arr[index + 1] = arr[index];
                //让index 向前移动
                index--;
            }
            //把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }

    private static void insertSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort4(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > val) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort5(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > val) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort6(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > val) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort7(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort8(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }
    }

    private static void insertSort9(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }

    }

    private static void insertSort10(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int index = i - 1;
            while (index >= 0 && val < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = val;
        }

    }

}
