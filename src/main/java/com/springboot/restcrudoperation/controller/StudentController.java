package com.springboot.restcrudoperation.controller;


import com.springboot.restcrudoperation.exception.ResourceNotFoundException;
import com.springboot.restcrudoperation.model.Student;
import com.springboot.restcrudoperation.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentRepository studentRepository;
    private static final String MESSAGE = "Student not found for this id :";
    private Student studentDetails;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student create(@Validated @RequestBody Student student) {
        return studentRepository.save(student);
    }
        @GetMapping("/students/{id}")
        public ResponseEntity<Student> getById(@PathVariable(value="id") long studentId) throws ResourceNotFoundException {
            Student student= studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException(MESSAGE + studentId));
            return ResponseEntity.ok().body(student);
        }
        @PutMapping("/students/{id}")
        public ResponseEntity<Student> update(@PathVariable(value = "id") long studentId) throws ResourceNotFoundException {
            Student student= studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException(MESSAGE + studentId));
            student.setFirstname(studentDetails.getFirstname());
            student.setLastname(studentDetails.getLastname());
            student.setEmailid(studentDetails.getEmailid());
            studentRepository.save(student);
            return ResponseEntity.ok().body(student);
        }
        @DeleteMapping("/students/{id}")
        public ResponseEntity<Student> deleteById(@PathVariable(value="id") long studentId) throws ResourceNotFoundException {
           Student student = studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException(MESSAGE + studentId));
            studentRepository.deleteById(studentId);
            return ResponseEntity.ok().body(student);
    }


}