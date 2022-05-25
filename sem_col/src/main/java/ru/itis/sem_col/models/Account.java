package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Account")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "NationalBank_ID")
    @JoinColumns({
            @JoinColumn(name ="NationalBank_ID"),
            @JoinColumn(name = "NationalBank_UUID")
    })
    private NationalBank national_bank;

    private String currency;

    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "organization_ID")
    @JoinColumns({
            @JoinColumn(name = "organization_ID"),
            @JoinColumn(name = "organization_UUID")
    })
    private Organization organization;

}
