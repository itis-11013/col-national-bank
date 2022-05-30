package ru.itis.sem_col.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.sem_col.models.Organization;

import java.util.Collection;

public class OrganizationDetailImple implements UserDetails {

    public Organization organization;

    public OrganizationDetailImple(Organization organization) {
        this.organization = organization;

        System.out.println(organization != null ? (organization.getName()  +  ":" + new BCryptPasswordEncoder().matches("admin", organization.getPassword())): "user not found");
    }

    public Organization getOrganization() {
        return organization;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        //System.out.println("organization password: " + organization.getPassword());
        return organization.getPassword();
    }

    @Override
    public String getUsername() {
        return organization.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
