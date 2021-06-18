package pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/18 14:08
 * <p>
 * Desc: 观察者模式
 */
public class ObserverPattern {

    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();

        subject.add(observer1);
        subject.add(observer2);

        subject.notifyAllObservers();
    }

}

/**
 * 抽象主题
 */
abstract class Subject {

    /**
     * 观察者列表
     */
    protected List<Observer> observers = new ArrayList<>();

    /**
     * 添加观察者绑定
     * @param observer 观察者
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 取消观察者绑定
     * @param observer 观察者
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者的方法
     */
    abstract void notifyAllObservers();

}

class ConcreteSubject extends Subject {

    @Override
    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.doSomething();
        }
    }

}

/**
 * 观察者接口
 */
interface Observer {

    /**
     * do something
     */
    void doSomething();
}

/**
 * 具体观察者1
 */
class Observer1 implements Observer {

    @Override
    public void doSomething() {
        System.out.println("Observer1 do some thing.");
    }

}

/**
 * 具体观察者2
 */
class Observer2 implements Observer {

    @Override
    public void doSomething() {
        System.out.println("Observer2 do some thing.");
    }

}