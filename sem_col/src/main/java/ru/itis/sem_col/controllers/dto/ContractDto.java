package ru.itis.sem_col.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDto {
    private boolean deleted = Boolean.FALSE;

    public boolean getDeleted() {
        return deleted;
    }
    public boolean setDeleted() {
        deleted = Boolean.TRUE;
        return deleted;
    }

}
