package com.kastking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class KastkingApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(KastkingApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  KASTKING ADMIN启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "\n" +
                "  _  __           _____ _______ _  _______ _   _  _____ \n" +
                " | |/ /    /\\    / ____|__   __| |/ /_   _| \\ | |/ ____|\n" +
                " | ' /    /  \\  | (___    | |  | ' /  | | |  \\| | |  __ \n" +
                " |  <    / /\\ \\  \\___ \\   | |  |  <   | | | . ` | | |_ |\n" +
                " | . \\  / ____ \\ ____) |  | |  | . \\ _| |_| |\\  | |__| |\n" +
                " |_|\\_\\/_/    \\_\\_____/   |_|  |_|\\_\\_____|_| \\_|\\_____|\n" +
                "                                                        \n" +
                "                                                        \n");
    }
}