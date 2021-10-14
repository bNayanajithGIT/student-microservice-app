package com.student.studenttransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTransactionsApplication.class, args);
    }

}
