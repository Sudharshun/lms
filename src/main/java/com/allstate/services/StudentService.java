package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private IStudentRepository repository;

    @Autowired
    public void setRepository(IStudentRepository repository){
        this.repository = repository;
    }

    public Student create(Student s){
        return this.repository.save(s);
    }

    public Student findById(int i) {

        return this.repository.findOne(i);
    }

    public Student findByEmail(String s) {
        return this.repository.findByEmail(s);
    }
}
