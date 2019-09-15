package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * Created by duyuqiang on 2019/9/4.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ApplicationMain {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(ApplicationMain.class,args);
    }
}
