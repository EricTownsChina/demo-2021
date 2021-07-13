package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class DemoCloudOrderApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCloudOrderApiApplication.class, args);
    }

}
