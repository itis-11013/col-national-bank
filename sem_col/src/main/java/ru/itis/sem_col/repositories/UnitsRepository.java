package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Units;

public interface UnitsRepository extends CrudRepository<Units, Long> {
}
