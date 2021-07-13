package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author eric
 */
@EnableFeignClients({"user", "order.service"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"user"})
public class DemoCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudUserApplication.class, args);
    }

}
