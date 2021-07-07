package juc.aqs;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/5 16:57
 * <p>
 * Desc: CylicBarrier的await()方法可以在等待线程中使用, 表示到达条件后, 该线程unpark(), 继续执行
 */
public class Test03_CylicBarrier {

    public static void main(String[] args) {
        // 个数为2时才会继续执行
        CyclicBarrier cb = new CyclicBarrier(2);
        new Thread(()->{
            System.out.println("线程1开始.."+new Date());
            try {
                cb.await(); // 当个数不足时，等待
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程1继续向下运行..."+new Date());
        }).start();
        new Thread(()->{
            System.out.println("线程2开始.."+new Date());
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
            try {
                cb.await(); // 2 秒后，线程个数够2，继续运行
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程2继续向下运行..."+new Date());
        }).start();
    }
}
