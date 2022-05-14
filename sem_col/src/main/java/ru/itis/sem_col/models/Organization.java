package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.composite.InnerOrganization;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "organization")
@Getter
@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(InnerOrganization.class)
public class Organization {
    @Id
    private Long id;

    @Id
    @Basic(optional = true)
    private Long innerId;

    private String address;

    private String password;



    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy="organization")
    private List<Account> accounts;
}
