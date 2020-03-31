package com.septemberhx.didi;

import com.septemberhx.mclient.annotation.MClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2020/3/31
 */
@SpringBootApplication
@EnableEurekaClient
@MClient
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
