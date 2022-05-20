package ru.itis.sem_col.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterOrganizationDto {
    private String address;

    private String password;

    private String name;
}
