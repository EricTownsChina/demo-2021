package leetcode.subject;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/21 17:17
 * <p>
 * Desc:
 */
public class Subject01 {


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


}
