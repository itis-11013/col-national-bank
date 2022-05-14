package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Account;
import ru.itis.sem_col.models.Organization;

import java.util.Optional;

public interface AccountRepository extends CrudRepository <Account, Long> {
    Account findByOrganization(Organization organization);
    Optional<Account> findById(Long id);
}
