package juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/5 9:24
 * <p>
 * Desc: 使用AQS的模板方法实现一个简单的不可重入锁
 */
public class Test01_AQS {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(() -> {
            myLock.lock();
            System.out.println("t1 lock...");
            try {
                System.out.println("t1 is sleeping...");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // ignore
            } finally {
                System.out.println("t1 unlock...");
                myLock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            myLock.lock();
            System.out.println("t2 lock...");
            try {
                System.out.println("t2 is sleeping...");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // ignore
            } finally {
                System.out.println("t2 unlock...");
                myLock.unlock();
            }
        }, "t2").start();

    }

}

final class MyLock implements Lock {
    static MySync mySync = new MySync();


    @Override
    public void lock() {
        // 这是AQS的一个模板方法, 会调用我们自己写的tryAcquire()
        // 不断自旋尝试加锁
        mySync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        // 这也是模板方法
        mySync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        // 只尝试一次
        return mySync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return mySync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        mySync.release(1);
    }

    @Override
    public Condition newCondition() {
        return mySync.newCondition();
    }
}

final class MySync extends AbstractQueuedSynchronizer {
    @Override
    protected boolean tryAcquire(int arg) {
        if (arg == 1) {
            // 尝试改变state
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        if (arg == 1) {
            // 不需要考虑并发, 因为当前持有锁
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }

            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        return false;
    }

    public Condition newCondition() {
        return new ConditionObject();
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
