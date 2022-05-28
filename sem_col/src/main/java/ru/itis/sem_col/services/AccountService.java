package ru.itis.sem_col.services;

import ru.itis.sem_col.controllers.dto.AccountDto;
import ru.itis.sem_col.models.Account;

import java.util.List;

public interface AccountService {
    Account find_by_organization_id(Long IdOrganization);
    List<Account> contextAccount();
    Account updateAcount(AccountDto AccountDto);
}
