package ru.itis.sem_col.models.composite;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.Organization;

import java.io.Serializable;
@Getter
@Setter
public class InnerOrganization implements Serializable {
    private Long id;
    private Long innerId;

}
