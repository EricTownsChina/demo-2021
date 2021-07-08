package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author eric
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoCloudOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudOrderApplication.class, args);
    }

}
