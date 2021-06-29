package collections.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/6/24 15:58
 * <p>
 * Desc:
 */
public class ArrayListTest {


    @Test
    public void initializeTest() {
        List<Integer> list = new ArrayList<>(15);
        System.out.println(list.size());

        // rangeCheck() index超过了size
        list.set(2, 1);
    }

}
