package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Acount")
@Getter
@Setter
public class Acount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "NationalBank_ID")
    @JoinColumns({
            @JoinColumn(name ="NationalBank_ID", insertable = false, updatable = false),
            @JoinColumn(name = "country_id", insertable = false, updatable = false)
    })
    private NationalBank national_bank;

    private String currency;

    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "organization_ID")
    @JoinColumns({
            @JoinColumn(name = "organization_ID"),
            @JoinColumn(name = "country_id")
    })
    private Organization organization;

}
