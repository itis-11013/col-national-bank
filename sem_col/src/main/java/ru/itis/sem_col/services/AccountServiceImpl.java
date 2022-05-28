package ru.itis.sem_col.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.controllers.dto.AccountDto;
import ru.itis.sem_col.models.Account;
import ru.itis.sem_col.repositories.AccountRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repositoryaccount;
    @Autowired
    private OrganizationDetailService organizationDetailService;

    @Override
    public Account find_by_organization_id(Long IdOrganization) {
        return repositoryaccount.findByOrganizationId(IdOrganization);
    }
    @Override
    public List<Account> contextAccount() {
        List <Account> accounts= organizationDetailService.getOrganization().getAccounts();
        System.out.println(accounts.get(0).getAmount());
        return accounts;
    }
    @Override
    public Account updateAcount(AccountDto AccountDto){
        List <Account> accounts= organizationDetailService.getOrganization().getAccounts();
        Account account = accounts.get(0);
        account.setAmount(account.getAmount()+ AccountDto.getAmount());
        repositoryaccount.save(account);
        return account;
    }
}
