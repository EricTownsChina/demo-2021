package user.servcie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/12 15:55
 * <p>
 * desc:
 */
@FeignClient("cloud-order-service-api")
public interface FeignOrderService {

    /**
     * feign order方法
     *
     * @return String
     */
    @RequestMapping("/orders")
    String orderService();

}
