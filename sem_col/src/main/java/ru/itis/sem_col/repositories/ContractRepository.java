package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.models.composite.InnerContract;

import java.util.List;
import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, InnerContract> {
    Contract findByInnerId(UUID uuid);

    @Query("select m from Contract m")
    List<Contract> getContracts();

}
