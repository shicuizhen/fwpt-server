package com.sjzxy.fwpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author scz
 */
@SpringBootApplication(scanBasePackages = "com.sjzxy.fwpt")
@EnableJpaRepositories(value = "com.sjzxy.fwpt.repository")
@EntityScan(value = "com.sjzxy.fwpt.entity")
public class FwptApplication {

    public static void main(String[] args) {
        SpringApplication.run(FwptApplication.class, args);
    }

}
