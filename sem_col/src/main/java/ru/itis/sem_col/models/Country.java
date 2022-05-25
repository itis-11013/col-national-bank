package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String code;




    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL})
    private List<Organization> organizations;

    @OneToMany(mappedBy = "country", cascade = {CascadeType.ALL})
    private List<NationalBank> banks;

}
