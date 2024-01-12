package com.tothenew.beach.springbootmongodb.controller;

import com.tothenew.beach.springbootmongodb.model.Student;
import com.tothenew.beach.springbootmongodb.service.StudentService;
import com.tothenew.beach.springbootmongodb.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        student = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Student>> saveAllStudent(@RequestBody List<Student> studentList) {
        studentList = studentService.saveAllStudent(studentList);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentList);
    }

    @GetMapping("/get/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentId) {
        Student student = studentService.getStudent(studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentList);
    }
}
