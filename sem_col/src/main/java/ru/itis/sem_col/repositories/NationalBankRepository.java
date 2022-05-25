package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.NationalBank;
import ru.itis.sem_col.models.composite.InnerNationalBank;

import java.util.List;
import java.util.UUID;

public interface NationalBankRepository extends CrudRepository<NationalBank, InnerNationalBank> {
    NationalBank findById(Long id);
    List<NationalBank> findNationalBankByAddress(String address);
}
