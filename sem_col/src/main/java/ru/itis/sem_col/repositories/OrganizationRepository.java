package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.models.composite.InnerOrganization;

import java.util.UUID;

public interface OrganizationRepository extends CrudRepository<Organization, InnerOrganization> {
    Organization findByName(String name);
    Organization findByInnerId(UUID uuid);
    Organization findById(Long id);
}
