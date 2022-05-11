package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Acount;
import ru.itis.sem_col.models.Organization;

import java.util.Optional;

public interface AccountRepository extends CrudRepository <Acount, Long> {
    Acount findByOrganization(Organization organization);
    Optional<Acount> findById(Long id);
}
