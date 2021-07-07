package user.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Eric 840017241@qq.com
 * @date 2021/7/6 14:48
 * <p>
 * Desc: user --> order   用户服务调用(采用负载均衡)订单服务(分布式部署)
 */
@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Resource
    private LoadBalancerClient loadBalancer;

    @GetMapping("/user/{id}")
    public String findById(@PathVariable("id") String id) {
//        // 没有加@LoadBalanced的代码实现
//        ServiceInstance serviceInstance = loadBalancer.choose("spring-cloud-order-service");
//
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort());
//        String service = "/orders";
//
//        return restTemplate.getForObject(url + service, String.class);

        return restTemplate.getForObject("http://spring-cloud-order-service/orders", String.class);

    }


}
