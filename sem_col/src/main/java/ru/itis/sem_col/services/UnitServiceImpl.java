package ru.itis.sem_col.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.sem_col.models.Units;
import ru.itis.sem_col.repositories.UnitsRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UnitServiceImpl implements UnitService{
    @Autowired
    UnitsRepository unitsRepository;
    @Override
    public List<Units> listAllUnits() {
        return (List<Units>) unitsRepository.findAll();
    }

}
