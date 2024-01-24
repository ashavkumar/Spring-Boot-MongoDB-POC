package com.tothenew.beach.springbootmongodb.controller;

import com.tothenew.beach.springbootmongodb.model.Student;
import com.tothenew.beach.springbootmongodb.service.StudentService;
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

    @PutMapping("/update/{studentId}")
    public ResponseEntity<?> updateStudent(@PathVariable int studentId, @RequestBody Student studentWithNewValue) {
        Student student = studentService.updateStudent(studentId, studentWithNewValue);
        if (student != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Student Study here.");
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId) {
        try {
            studentService.deleteStudent(studentId);
            return ResponseEntity.status(HttpStatus.OK).body("Student data successfully deleted from the Server!");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Such Student found here.");
        }
    }
}
