package ru.itis.sem_col.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.models.composite.InnerOrganization;

public interface OrganizationRepository extends CrudRepository<Organization, InnerOrganization> {
    Organization findById(Long id);
}
