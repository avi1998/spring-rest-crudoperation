package com.springboot.restcrudoperation;

import com.springboot.restcrudoperation.controller.StudentController;
import com.springboot.restcrudoperation.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringRestCrudoperationApplicationTests {

    @InjectMocks
    StudentController controller;

    @Mock
    Student student;



    @Test
     void createTest()
    {
      Assertions.assertNotNull(student);
    }

    @Test
     void getByIdTest()  {
        Assertions.assertNotNull(student);

    }

    @Test
     void getAllTest()
    {
       Assertions.assertNotNull(student);
    }

    @Test
    void updateTest()  {
       Assertions.assertNotNull(student);
    }

    @Test
     void deleteByIdTest()  {
        Assertions.assertNotNull(student);
    }



}
