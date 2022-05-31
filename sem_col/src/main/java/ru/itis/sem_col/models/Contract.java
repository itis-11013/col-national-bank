package ru.itis.sem_col.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import ru.itis.sem_col.models.composite.InnerContract;
import ru.itis.sem_col.models.composite.InnerNationalBank;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "contract")
@Getter
@Setter
@IdClass(InnerContract.class)
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;//

    @Id
    private UUID innerId;//

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime contractDate;//

    private LocalDateTime paymentDate;//

    private LocalDateTime deliveryDate;//

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name ="product_ID"),
            @JoinColumn(name = "product_UUID")
    })
    private Product product;//

    @OneToOne
    private Organization buyer;//

    private double count;//

    private boolean deleted;//
}
