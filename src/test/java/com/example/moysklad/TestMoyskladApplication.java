package com.example.moysklad;

import org.springframework.boot.SpringApplication;

public class TestMoyskladApplication {

    public static void main(String[] args) {
        SpringApplication.from(MoyskladApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
