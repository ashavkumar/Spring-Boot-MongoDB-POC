package com.tothenew.beach.springbootmongodb.service;

import com.tothenew.beach.springbootmongodb.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> saveAllStudent(List<Student> studentList);

    public Student getStudent(int studentId);

    public List<Student> getAllStudent();

    public Student updateStudent(int studentId, Student studentWithNewValue);

    public void deleteStudent(int studentId);

    public Student findStudentByName(String studentName);
}
