package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enumerations.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeachersServiceTest {

    @Autowired
    private TeachersService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher before= new Teacher();
        before.setName("Jane");
        before.setAge(44);
        before.setGender(Gender.FEMALE);

        Teacher after = service.create(before);
        assertEquals(4,after.getId());
        assertEquals("Jane",after.getName());

    }


    @Test
    public void shouldFindByName() throws Exception {
        Teacher t = this.service.findByName("Johnn");
        assertNotNull(t);
    }

    @Test
    public void shouldnotFindByBadName() throws Exception {
        Teacher t = this.service.findByName("Johnx");
        assertNull(t);
    }


    @Test
    public void shouldFindByID() throws Exception {
        Teacher t = this.service.findByID(2);
        assertNotNull(t);
    }

    @Test
    public void shouldnotFindByBadID() throws Exception {
        Teacher t = this.service.findByID(76);
        assertNull(t);
    }

    @Test
    public void shouldFindByGender() throws Exception {
        List<Teacher> t = this.service.findByGender(Gender.FEMALE);
        assertNotNull(t);
    }

    @Test
    public void shouldFindTeachersOlderThanAge() throws Exception {
        List<Teacher> t = this.service.OlderThanAge(22);
        assertNotNull(t);
        assertEquals(2,t.size());
    }




}