package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;
import ru.itis.sem_col.models.composite.InnerProduct;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@IdClass(InnerProduct.class)
public class Product implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
//    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    @Id
    @Basic(optional = true)
    private UUID innerId;

    private String code;

    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_id")
    private Units unit;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    private ProductCatalog catalog;

    @ManyToOne
    //@JoinColumn(name = "organization_ID")
    @JoinColumns({
            @JoinColumn(name = "organization_ID"),
            @JoinColumn(name = "country_id")
    })
    private Organization organization;

    private Long price;

    private Integer count;
}
