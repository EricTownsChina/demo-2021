package user.controller;

import order.service.OrderServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/12 20:18
 * <p>
 * desc:
 */
@RestController("uuu")
public class UserController2 {

    @Resource
    private OrderServiceFeignClient orderServiceFeignClient;

    @GetMapping("/user2/{id}")
    public String orders(@PathVariable String id) {
        return orderServiceFeignClient.orders();
    }

}
