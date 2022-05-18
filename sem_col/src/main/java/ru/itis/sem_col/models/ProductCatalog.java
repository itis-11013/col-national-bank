package ru.itis.sem_col.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_catalog")
@Getter
@Setter
public class ProductCatalog {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    @Id
    private Long id;

    private String code;
    private String name;

    @OneToMany(mappedBy = "catalog")
    private List<Product> products;
}
