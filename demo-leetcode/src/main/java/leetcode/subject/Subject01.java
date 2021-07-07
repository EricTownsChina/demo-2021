package leetcode.subject;

import lombok.ToString;
import org.junit.Test;

import java.util.*;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/21 17:17
 * <p>
 * Desc:
 */
@ToString
public class Subject01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String inStr = in.nextLine();
            if ("".equals(inStr.trim())) {
                continue;
            }

            String[] arr = inStr.split(",");

            StringBuilder numberStr = new StringBuilder();
            for (String i : arr) {
                numberStr.append(i);
            }
            String s = numberStr.toString();

            long number = Long.parseLong(s);
            number++;
            s = String.valueOf(number);
            int length = s.length();
            long[] result = new long[length];
            for (int i = 0; i < length; i++) {
                long l = Long.parseLong(String.valueOf(s.charAt(i)));
                result[i] = l;
                System.out.print(l + ",");
            }
        }
    }

    @Test
    public void testXy() {



//        long[] arr = new long[] {9L};
//        System.out.println(Arrays.toString(handle(arr)));


    }

    private long[] handle(long[] arr) {
        if (arr[0] == 0) {
            return new long[] {1};
        }

        StringBuilder numberStr = new StringBuilder();
        for (long i : arr) {
            numberStr.append(i);
        }
        String s = numberStr.toString();

        long number = Long.parseLong(s);
        number++;
        s = String.valueOf(number);
        int length = s.length();
        long[] result = new long[length];
        for (int i = 0; i < length; i++) {
            result[i] = Long.parseLong(String.valueOf(s.charAt(i)));
        }

        return result;

    }




    /**
     * 直线上最多的点数
     */
    @Test
    public void testMaxPoints() {
//        int[][] points = {{1,1}, {2,2}, {3,3}};    // 3
//        int[][] points = {{0,0}};    // 1
//        int[][] points = {{0,0}, {1,-1}, {1,1}};    // 2
//        int[][] points = {{1,1}, {3,2}, {5,3},{4,1}, {2,3}, {1,4}};    // 4
//        int[][] points = {{2,3}, {3,3}, {-5,3}};    // 4
        int[][] points = {{0,1}, {0,0}, {0,4}, {0,-2}, {0,-1}, {0,3}, {0,-4}};    // 4
        System.out.println(maxPoints(points));
    }

    private int maxPoints(int[][] points) {
        int pnums = points.length;

        // y轴的下限是1, 上限是300
        // x轴的下限是1, 上限是300
        int index = 0;
        List<List<Integer>> pointRecords = new ArrayList<>();
        for (int i = 0; i < pnums; i++) {
            for (int j = i + 1; j < pnums; j++) {
                boolean flag = false;
                for (List<Integer> record : pointRecords) {
                    if (record.contains(i) && record.contains(j)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                List<Integer> record = new ArrayList<>();
                record.add(i);
                record.add(j);
                pointRecords.add(index, record);

                for (int k = j + 1; k < pnums; k++ ) {
                    int[] point_i = points[i];
                    int[] point_j = points[j];
                    int[] point_k = points[k];

                    // ij两点间直线的斜率
                    Double x_ij = (double)(point_j[1] - point_i[1]) / (point_j[0] - point_i[0]) + 0.0d;

                    // ik两点间直线的斜率
                    Double x_ik = (double)(point_k[1] - point_i[1]) / (point_k[0] - point_i[0]) + 0.0d;

                    if (x_ij.isInfinite() && x_ik.isInfinite()) {
                        record.add(k);
                    } else if (x_ij.equals(x_ik)) {
                        record.add(k);
                    }
                }
                index++;
            }
        }


        List<Integer> lengthList = new ArrayList<>();
        for (List<Integer> record : pointRecords) {
            int size = record.size();
            lengthList.add(size);
        }

        if (lengthList.size() == 0) {
            return points.length;
        }

        return Collections.max(lengthList);
    }

    @Test
    public void print() {
        System.out.println("eee");
    }


    @Test
    public void testOpenLock() {
        String[] deadendsArr = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";

        System.out.println(openLock(deadendsArr, target));
    }

    private int openLock(String[] deadends, String target) {
        // 0000 直接返回
        List<String> deadendsList = Arrays.asList(deadends);
        if (deadendsList.contains("0000") || deadendsList.contains(target)) {
            return -1;
        }
        List<String> notList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<String> around = around(target, i);
            notList.addAll(around);
        }
        if (deadendsList.containsAll(notList)) {
            return -1;
        }

        // target位置上有没有数值





        return 0;
    }

    private List<String> around(String target, int index) {
        List<String> aroundList = new ArrayList<>();
        String iStr = String.valueOf(target.charAt(index));
        int i = Integer.parseInt(iStr);
        int next = next(i);
        int pre = pre(i);
        String preStr = target.substring(0, index);
        String postStr = target.substring(index + 1);
        aroundList.add(preStr + next + postStr);
        aroundList.add(preStr + pre + postStr);
        return aroundList;
    }

    private int next(int a) {
        if (a < 0 || a > 9) {
            return -1;
        }
        if (a == 9) {
            return 0;
        }
        return a + 1;
    }

    private int pre(int a) {
        if (a < 0 || a > 9) {
            return -1;
        }
        if (a == 0) {
            return 9;
        }
        return a - 1;
    }


}
