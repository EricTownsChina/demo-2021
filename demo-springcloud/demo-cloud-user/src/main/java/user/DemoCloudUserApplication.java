package user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author eric
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemoCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudUserApplication.class, args);
    }

}
