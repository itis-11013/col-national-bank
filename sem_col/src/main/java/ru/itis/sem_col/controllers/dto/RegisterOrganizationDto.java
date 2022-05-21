package ru.itis.sem_col.controllers.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterOrganizationDto {
    private String address;

    @NotNull
    private String password;

    private String name;
}
