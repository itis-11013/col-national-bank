package ru.itis.sem_col;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OrganizationTest {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}