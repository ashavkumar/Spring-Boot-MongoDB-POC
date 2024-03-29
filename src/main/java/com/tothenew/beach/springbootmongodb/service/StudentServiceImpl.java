package com.tothenew.beach.springbootmongodb.service;

import com.tothenew.beach.springbootmongodb.model.Student;
import com.tothenew.beach.springbootmongodb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Student updateStudent(int studentId, Student studentWithNewValue) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student studentToBeUpdate = studentOptional.get();
            studentToBeUpdate.setCollege(studentWithNewValue.getCollege() != null ? studentWithNewValue.getCollege() : studentToBeUpdate.getCollege());
            studentToBeUpdate.setCity(studentWithNewValue.getCity() != null ? studentWithNewValue.getCity() : studentToBeUpdate.getCity());
            return studentRepository.save(studentToBeUpdate);
        } else {
            return studentOptional.get();
        }
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    public Student findStudentByName(String studentName) {
        return studentRepository.findStudentByName(studentName).get();
    }
}