package ru.itis.sem_col.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.sem_col.models.Contract;

import java.util.List;
import java.util.UUID;

public interface ContractService {
    List<Contract> getAllContracts();
    Contract addNewContract(UUID productUUID, Integer count) throws JsonProcessingException;
}
