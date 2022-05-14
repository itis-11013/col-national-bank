package ru.itis.sem_col.controllers.dto;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginFormDto {
    private String name;
    private String password;
}