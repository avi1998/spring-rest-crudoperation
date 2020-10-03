package com.springboot.restcrudoperation.repository;

import com.springboot.restcrudoperation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

}
