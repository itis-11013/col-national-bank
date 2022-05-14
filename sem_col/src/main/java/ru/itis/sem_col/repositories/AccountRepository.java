package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.sem_col.models.Account;
import ru.itis.sem_col.models.Organization;

import java.util.Optional;

public interface AccountRepository extends CrudRepository <Account, Long> {
    @Query("select r from Organization r where r.id = :id ")
    Account findByOrganizationId(@Param("id") Long id);

}
