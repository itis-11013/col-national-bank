package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.NationalBank;
import ru.itis.sem_col.models.composite.InnerNationalBank;

public interface NationalBankRepository extends CrudRepository<NationalBank, InnerNationalBank> {
    NationalBank findById(Long id);
}
