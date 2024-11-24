package tn.pi.trainermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InternalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalManagementApplication.class, args);
    }

}
