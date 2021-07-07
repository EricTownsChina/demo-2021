package juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/7 15:36
 * <p>
 * Desc:
 */
public class AtomicTest01 {

    private volatile int i;

    public static void main(String[] args) {
        // 原子变量
//        atomicVariable();

        // 字段更新器
        // 只能配合volatile字段使用
        AtomicTest01 test = new AtomicTest01();
        AtomicIntegerFieldUpdater<AtomicTest01> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicTest01.class, "i");
        updater.compareAndSet(test, 0, 3);
        System.out.println(test.i);


    }

    private static void atomicVariable() {
        // 原子整数
        // 用过CAS保证线程安全
        AtomicInteger a = new AtomicInteger(0);

        System.out.println(a.getAndAccumulate(10, (p, x) -> {
            if (p == 0) {
                p = 11;
            }
            return p;
        }));
        System.out.println(a.get());


        // 可以防止ABA问题的出现
        // 带有版本的原子变量
        AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 4);

        String reference = ref.getReference();
        int stamp = ref.getStamp();
        if ("A".equals(reference)) {
            ref.compareAndSet("A", "C", stamp, stamp + 1);
        }


        // 标记量的原子变量
        // 不在乎ABA问题的情况
        AtomicMarkableReference<String> markRef = new AtomicMarkableReference<>("A", true);
    }


}
