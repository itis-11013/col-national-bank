package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Contract;
import ru.itis.sem_col.models.composite.InnerContract;

import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, InnerContract> {
    Contract findByInnerId(UUID uuid);

}
