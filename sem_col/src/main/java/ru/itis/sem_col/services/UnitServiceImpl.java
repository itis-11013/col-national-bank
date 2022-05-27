package ru.itis.sem_col.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.models.Units;
import ru.itis.sem_col.repositories.UnitsRepository;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService{
    @Autowired
    UnitsRepository unitsRepository;
    @Override
    public List<Units> listAllUnits() {
        return (List<Units>) unitsRepository.findAll();
    }
}
