package com.tothenew.beach.springbootmongodb.service;

import com.tothenew.beach.springbootmongodb.model.Student;
import com.tothenew.beach.springbootmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAllStudent(List<Student> studentList) {
        return studentRepository.saveAll(studentList);
    }

    public Student getStudent(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
