package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.models.composite.InnerContract;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, InnerContract> {
    Contract findByInnerId(UUID uuid);

    @Query("select m from Contract m")
    List<Contract> getContracts();

    @Modifying
    @Query("update Contract u set u.deleted = ?1, u.paymentDate = ?3 where u.innerId = ?2")
    void update(Boolean isPaid, UUID innerid, LocalDateTime paymentDate);

}
