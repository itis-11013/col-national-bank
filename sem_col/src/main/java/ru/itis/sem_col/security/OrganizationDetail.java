package ru.itis.sem_col.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.repositories.OrganizationRepository;
import ru.itis.sem_col.services.OrganizationDetailService;

@Service(value = "myOrganizationDetailService")
public class OrganizationDetail implements UserDetailsService {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private OrganizationDetailService organizationDetailService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Organization organization = organizationRepository.findByName(username);

        if (organization != null) {
            organizationDetailService.setOrganization(organization);
            //List<UserRole> roles = roleRepository.findByUser(user.getId());
            //user.setRoles(roles);
            return new OrganizationDetailImple(organization);
        } throw new UsernameNotFoundException("Organization not found!");
    }
}
