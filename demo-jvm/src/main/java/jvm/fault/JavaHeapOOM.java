package jvm.fault;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/15 9:24
 * <p>
 * Desc: java堆溢出
 */
public class JavaHeapOOM {

    public static void main(String[] args) {
        // list分配在heap中
        List<JavaHeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new JavaHeapOOM());
        }
    }

}
