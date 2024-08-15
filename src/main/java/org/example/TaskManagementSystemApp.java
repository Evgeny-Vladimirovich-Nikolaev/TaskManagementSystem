package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan
public class TaskManagementSystemApp
{
    public static void main(String[] args) {
        SpringApplication.run(TaskManagementSystemApp.class, args);
    }
}
