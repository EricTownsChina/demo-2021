package order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/12 20:04
 * <p>
 * desc:
 */
public interface OrderServiceApi {

    /**
     * 获取所有的orders
     *
     * @return orders
     */
    @GetMapping("/all-orders")
    String orders();

}
