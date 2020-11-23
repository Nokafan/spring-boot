package com.gmail.stepura.volodymyr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {
        "com.gmail.stepura.volodymyr.config",
        "com.gmail.stepura.volodymyr.repository",
        "com.gmail.stepura.volodymyr.service"})
public class AppConfig {

}
