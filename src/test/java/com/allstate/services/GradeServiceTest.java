package com.allstate.services;

import com.allstate.entities.Grade;
import com.allstate.entities.Klass;
import com.allstate.entities.Student;
import com.allstate.entities.Teacher;
import com.allstate.enumerations.Department;
import com.allstate.enumerations.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by localadmin on 2/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class GradeServiceTest {

    @Autowired
    private GradeService service;

    @Autowired
    private TeachersService teachersService;

    @Autowired
    private StudentService studentService;


    @Autowired
    private KlassService klassService;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldSaveGrade() throws Exception {

        Student newGuy= new Student();
        newGuy.setEmail("test12@example.com");
        Student createdGuy= studentService.create(newGuy);

        Klass newKlass= new Klass();
        newKlass.setName("Physicks 102");
        newKlass.setCredits(3);
        newKlass.setDepartment(Department.SCIENCE);
        newKlass.setFee(350.00);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2017-10-01 ");

        newKlass.setSemester(d);

        //Creating Teacher

        Teacher teacher= new Teacher();
        teacher.setName("Jane");
        teacher.setAge(44);
        teacher.setGender(Gender.FEMALE);

        Teacher createdTeacher = teachersService.create(teacher);

        //Creating Teacher

        newKlass.setTeacher(createdTeacher);

        Klass createdKlass = klassService.create(newKlass);

        Grade before =new Grade(80,true,createdGuy,createdKlass);

        Grade after = this.service.save(before);
        assertEquals(80, after.getValue());


    }


}