package order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/12 20:14
 * <p>
 * desc:
 */
@FeignClient("cloud-order-service")
public interface OrderServiceFeignClient extends OrderServiceApi {

}
