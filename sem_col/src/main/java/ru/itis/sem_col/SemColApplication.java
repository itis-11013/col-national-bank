package ru.itis.sem_col;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.itis.sem_col.services.RestService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SemColApplication {
    public static void main(String[] args) {

        SpringApplication.run(SemColApplication.class, args);
    }

}
