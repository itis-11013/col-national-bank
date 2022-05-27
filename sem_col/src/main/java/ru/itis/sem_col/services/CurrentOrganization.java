package ru.itis.sem_col.services;

import ru.itis.sem_col.models.Organization;

public class CurrentOrganization {
    private Organization organization;

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Organization getOrganization() {
        return organization;
    }
}
