package com.allstate.repositories;

/**
 * Created by localadmin on 2/9/17.
 */

import com.allstate.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Integer> {
    public Student findByEmail(String email);
}
