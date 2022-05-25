package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;

public interface IOrgService {
    void registerNewOrganization(RegisterOrganizationDto organizationDto) throws JsonProcessingException;
}
