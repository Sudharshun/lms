package com.allstate.services;

import com.allstate.entities.Teacher;

import com.allstate.enumerations.Gender;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachersService {

    private ITeacherRepository repository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository) {
        this.repository = teacherRepository;
    }

    public Teacher create(Teacher t){
        return this.repository.save(t);
    }


    public Teacher findByName(String name) {
        return this.repository.findByName(name);
    }


    public Teacher findByID(int id) {
        return this.repository.findOne(id);
    }

    public List<Teacher> findByGender(Gender female) {
            return this.repository.findByGender(female);

    }

    public List<Teacher> OlderThanAge(int i) {
        return this.repository.findByAgeGreaterThan(i);
    }
}
