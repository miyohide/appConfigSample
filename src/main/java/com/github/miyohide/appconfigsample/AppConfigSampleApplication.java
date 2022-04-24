package com.github.miyohide.appconfigsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MessageProperties.class)
public class AppConfigSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppConfigSampleApplication.class, args);
    }

}
