package com.kastking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication
@EnableEurekaClient
public class KastkingTestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KastkingTestServerApplication.class, args);
    }

}
