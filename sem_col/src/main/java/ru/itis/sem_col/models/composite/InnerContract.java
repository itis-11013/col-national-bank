package ru.itis.sem_col.models.composite;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InnerContract implements Serializable {
    private Long id;
    private Long innerId;
}
