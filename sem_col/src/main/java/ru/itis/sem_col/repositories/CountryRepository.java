package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Country;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findById(Long id);
    Country findByName(String name);
    Country findByCode(String code);
}
