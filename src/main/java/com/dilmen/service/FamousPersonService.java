package com.dilmen.service;

import com.dilmen.repository.IFamousPersonRepository;
import com.dilmen.repository.entity.FamousPerson;
import com.dilmen.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class FamousPersonService extends ServiceManager<FamousPerson,Long> {

    private final IFamousPersonRepository famousPersonRepository;
    public FamousPersonService(IFamousPersonRepository famousPersonRepository){
        super(famousPersonRepository);
        this.famousPersonRepository = famousPersonRepository;
    }

}
