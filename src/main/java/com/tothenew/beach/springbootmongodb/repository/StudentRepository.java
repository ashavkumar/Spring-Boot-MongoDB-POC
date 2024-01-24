package com.tothenew.beach.springbootmongodb.repository;

import com.tothenew.beach.springbootmongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    @Query("{'studentName' : ?0}")
    Optional<Student> findStudentByName(String studentName);
}
