package jvm.fault;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/15 10:34
 * <p>
 * Desc: Java栈溢出
 */
public class JavaStackOverFlow {

    public static void main(String[] args) {
        JavaStackOverFlow javaStackOverFlow = new JavaStackOverFlow();
        try {
            javaStackOverFlow.stackLeak();
        } catch (Throwable e) {
            System.out.println("length: " + javaStackOverFlow.stackLength);
            throw e;
        }
    }

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        System.out.println("length: " + stackLength);
        stackLeak();
    }

}
