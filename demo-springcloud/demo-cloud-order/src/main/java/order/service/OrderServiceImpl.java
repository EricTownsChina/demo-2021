package order.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/12 20:07
 * <p>
 * desc:
 */
@RestController
public class OrderServiceImpl implements OrderServiceApi {

    @Override
    public String orders() {
        return "all orders";
    }

}
