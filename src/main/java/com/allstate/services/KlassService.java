package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.repositories.IKlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KlassService {

    private IKlassRepository repository;

    @Autowired
    public void setRepository(IKlassRepository repository) {
        this.repository = repository;
    }

    public Klass create(Klass k){
        return this.repository.save(k);
    }

    public Klass findById(int i) {
        return this.repository.findOne(i);
    }


    public Klass findByName(String s){
        return this.repository.findByName(s);
    }
}
