package com.pedrogonic.dockerspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerspringdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerspringdemoApplication.class, args);

        System.out.println("Testing caching!");

    }

}
