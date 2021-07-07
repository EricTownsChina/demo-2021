package order.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/6 14:51
 * <p>
 * Desc: order 订单服务对外暴露的接口
 */
@RestController
public class OrderService {

    @Value("${server.port}")
    private String port;

    @GetMapping("/orders")
    public String all() {

        System.out.println("port: " + port);

        return "this is all orders";
    }

}
