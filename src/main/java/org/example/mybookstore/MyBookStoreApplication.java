package org.example.mybookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.example.mybookstore"})
public class MyBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBookStoreApplication.class, args);
    }

}
