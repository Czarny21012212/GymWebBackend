package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dataService {

    @Autowired
    private dataRepo dataRepo;

    public personData activatePass(personData personData){
      return dataRepo.save(personData);
    }

    public List<personData> yourPass(){
        return dataRepo.findAll();
    }

    public void deletePass(long id){
        dataRepo.deleteById((long) id);
    }

    public personData findById(long id){
        return dataRepo.findById((long) id).get();
    }
}
