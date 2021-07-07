package juc.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/5 16:50
 * <p>
 * Desc: await()方法是CountDownLatch对象的方法, 也就是说, 倒计时结束后, 持有CountDownLatch对象的线程(当前线程)才会执行
 *
 * CountDownLatch跟CyclicBarrier不一样的点就是到点执行后续方法的执行者不一样
 */
@Slf4j
public class Test02_CountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Thread(() -> {
            log.debug("begin...");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();
        new Thread(() -> {
            log.debug("begin...");
            try {
                sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();
        new Thread(() -> {
            log.debug("begin...");
            try {
                sleep((long) 1.5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            log.debug("end...{}", latch.getCount());
        }).start();



        log.debug("waiting...");
        latch.await();
        log.debug("wait end...");
    }

}
