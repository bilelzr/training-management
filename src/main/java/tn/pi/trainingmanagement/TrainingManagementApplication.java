package tn.pi.trainingmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrainingManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingManagementApplication.class, args);
    }

}
