package org.example.pkmn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
public class PkmnGraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(PkmnGraphApplication.class, args);
    }
}
