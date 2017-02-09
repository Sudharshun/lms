package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {
    @Autowired
    private StudentService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateStudent() throws Exception {
        Student before = new Student();
        before.setEmail("test1@example.com");
        Student after = this.service.create(before);
        assertEquals(5, after.getId());
        assertEquals(0, after.getVersion());
        assertEquals("test1@example.com", after.getEmail());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotCreateStudentNoEmail() throws Exception {
        Student before = new Student();
        Student after = this.service.create(before);
        assertEquals(4, after.getId());
    }

    @Test
    public void shouldFindStudentById() throws Exception {
        Student s = this.service.findById(1);
        assertNotNull(s);
    }

    @Test
    public void shouldNotFindStudentForBadIds() throws Exception {
        Student s = this.service.findById(-999);
        assertNull(s);
    }
    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student s = this.service.findByEmail("aaa@example.com");
        assertNotNull(s);
    }

    @Test
    public void shouldNotFindStudentForBadEmail() throws Exception {
        Student s = this.service.findByEmail("aaa@e1xa1mpl1e.com");
        assertNull(s);
    }





}