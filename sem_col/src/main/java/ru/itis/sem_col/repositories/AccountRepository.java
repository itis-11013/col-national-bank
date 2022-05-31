package ru.itis.sem_col.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.sem_col.models.Account;
import ru.itis.sem_col.models.Organization;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends CrudRepository <Account, Long> {
    @Query("select r from Organization r where r.id = :id ")
    Account findByOrganizationId(@Param("id") Long id);

    @Modifying
    @Query("update Account u set u.amount = ?1 where u.id = ?2")
    void updateAmount(Long amount, Organization organization);
}
