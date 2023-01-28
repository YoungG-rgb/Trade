package kg.tech.retailment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RetailmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailmentApplication.class, args);
    }

}
