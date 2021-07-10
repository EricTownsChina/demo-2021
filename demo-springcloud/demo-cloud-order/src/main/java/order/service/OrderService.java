package order.service;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/6 14:51
 * <p>
 * Desc: order 订单服务对外暴露的接口
 * 服务注册到注册中心上
 */
@RefreshScope
@RestController
public class OrderService {

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private Integer userAge;

    @GetMapping("/orders")
    public String all() {

        System.out.println("port: " + port);

        return "this is all orders, user name = " + userName + ", user age = " + userAge;
    }

}
