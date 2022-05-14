package ru.itis.sem_col.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.models.Organization;
import ru.itis.sem_col.repositories.OrganizationRepository;

@Service(value = "myOrganizationDetailService")
public class OrganizationDetailService  implements UserDetailsService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Organization organization = organizationRepository.findByName(username);
        if (organization != null) {
            //List<UserRole> roles = roleRepository.findByUser(user.getId());
            //user.setRoles(roles);
            return new OrganizationDetailImple(organization);
        } throw new UsernameNotFoundException("Organization not found!");
    }
}
