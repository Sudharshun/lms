package com.allstate.repositories;

import com.allstate.entities.Teacher;
import com.allstate.enumerations.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {

    public Teacher findByName(String name);

    public List<Teacher> findByGender(Gender gender);

    List<Teacher> findByAgeGreaterThan(int i);
}
