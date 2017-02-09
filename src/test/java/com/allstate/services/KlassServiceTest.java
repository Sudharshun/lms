package com.allstate.services;

import com.allstate.entities.Klass;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    private KlassService service;
    @Autowired
    private TeachersService teachersService;



    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateKlass() throws Exception {
    Klass before =new Klass();

        before.setName("Phy 102");
        before.setCredits(3);
        before.setDepartment(Department.SCIENCE);
        before.setFee(350.00);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2017-10-01 ");

        before.setSemester(d);

        //Creating Teacher

        Teacher teacher= new Teacher();
        teacher.setName("Jane");
        teacher.setAge(44);
        teacher.setGender(Gender.FEMALE);

        Teacher createdTeacher = teachersService.create(teacher);

        //Creating Teacher

        before.setTeacher(createdTeacher);


        Klass after = this.service.create(before);
        assertEquals(4, after.getId());
        assertEquals(0, after.getVersion());
        assertEquals("Phy 102", after.getName());

    }

    @Test
    public void shouldFindByName() throws Exception {
        Klass k = this.service.findByName("Calculus 101");
        assertNotNull(k);
    }

    @Test
    public void shouldnotFindByBadName() throws Exception {
        Klass k = this.service.findByName("Calculusvcg 1012");
        assertNull(k);
    }


    @Test
    public void shouldFindByID() throws Exception {
        Klass k = this.service.findById(2);
        assertNotNull(k);
    }

    @Test
    public void shouldnotFindByBadID() throws Exception {
        Klass k = this.service.findById(76);
        assertNull(k);
    }




}