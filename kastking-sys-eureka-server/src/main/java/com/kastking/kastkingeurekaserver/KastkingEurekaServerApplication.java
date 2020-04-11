package com.kastking.kastkingeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KastkingEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KastkingEurekaServerApplication.class, args);
    }

}
