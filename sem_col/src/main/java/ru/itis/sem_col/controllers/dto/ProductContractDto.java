package ru.itis.sem_col.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductContractDto {
    private Long merch_id;
    private String merch_code;
    private Integer count;
}
