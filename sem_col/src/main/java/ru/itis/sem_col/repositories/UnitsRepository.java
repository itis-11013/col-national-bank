package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Units;

import java.util.Optional;

public interface UnitsRepository extends CrudRepository<Units, Long> {
    Optional<Units> findById(Long id);
    Units findByCode(String code);
}
