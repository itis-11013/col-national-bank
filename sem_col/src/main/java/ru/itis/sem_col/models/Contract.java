package ru.itis.sem_col.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.itis.sem_col.models.composite.InnerContract;
import ru.itis.sem_col.models.composite.InnerNationalBank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "contract")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@IdClass(InnerContract.class)
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    @Id
    @Basic(optional = true)
    private Long innerId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime contractDate;

    private LocalDateTime paymentDate;

    private Date deliveryDate;

    @ManyToOne
    private Product product;

    @OneToOne
    private Organization buyer;

    private double count;

    private boolean deleted = Boolean.FALSE;
}
