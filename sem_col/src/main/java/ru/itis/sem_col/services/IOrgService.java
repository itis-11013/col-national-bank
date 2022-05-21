package ru.itis.sem_col.services;

import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;
import ru.itis.sem_col.models.Organization;

public interface IOrgService {
    Organization registerNewOrganization(RegisterOrganizationDto organizationDto);
}
