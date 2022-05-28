package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.composite.InnerOrganization;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "organization")
@Getter
@Setter
//@Inheritance(strategy = InheritanceType.JOINED)
@IdClass(InnerOrganization.class)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Id
    @Basic(optional = true)
    private UUID innerId;

    private String address;

    private String password;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy="organization", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Account> accounts;
    
    @OneToMany(mappedBy = "organization", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Product> products;

}
