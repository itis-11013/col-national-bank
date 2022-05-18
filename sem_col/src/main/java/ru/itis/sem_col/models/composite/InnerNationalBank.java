package ru.itis.sem_col.models.composite;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class InnerNationalBank implements Serializable {
    private Long id;
    private UUID innerId;
}
