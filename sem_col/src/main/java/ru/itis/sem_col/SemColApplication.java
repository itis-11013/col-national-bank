package ru.itis.sem_col;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SemColApplication {
    public static void main(String[] args) {

        SpringApplication.run(SemColApplication.class, args);
    }

}
