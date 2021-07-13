package product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class DemoCloudProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudProductApplication.class, args);
    }

}
