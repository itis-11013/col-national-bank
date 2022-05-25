package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.composite.InnerNationalBank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "NationalBank")
@Getter
@Setter
@IdClass(InnerNationalBank.class)
public class NationalBank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    private UUID innerId;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;
}
