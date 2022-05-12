package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "units")
@Getter
@Setter
public class Units {
    @Id
    private long id;

    private String code;

    private String type;


}
