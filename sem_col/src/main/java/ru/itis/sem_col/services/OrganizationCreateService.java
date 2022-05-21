package ru.itis.sem_col.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.controllers.dto.RegisterOrganizationDto;
import ru.itis.sem_col.models.Country;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.repositories.CountryRepository;
import ru.itis.sem_col.repositories.OrganizationRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class OrganizationCreateService implements IOrgService{
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Organization registerNewOrganization(RegisterOrganizationDto organizationDto) {
        UUID uuid = UUID.randomUUID();
        Country country = countryRepository.findByCode("co");
        Organization organization = new Organization();
        organization.setName(organizationDto.getName());
        organization.setAddress(organizationDto.getAddress());
        organization.setPassword(organizationDto.getPassword());
        organization.setInnerId(uuid);
        organization.setCountry(country);

        System.out.println(organization);
        return organizationRepository.save(organization);
    }
}
