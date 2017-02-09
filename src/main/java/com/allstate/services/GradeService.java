package com.allstate.services;

import com.allstate.entities.Grade;
import com.allstate.repositories.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Created by localadmin on 2/9/17.
 */

@Service
@Transactional
public class GradeService {


    private IGradeRepository repository;

    @Autowired
    public void setRepository(IGradeRepository repository) {
        this.repository = repository;
    }

    public Grade save(Grade grade){
        return this.repository.save(grade);
    }


    public Grade findById(int id){
        return this.repository.findOne(id);
    }

}
