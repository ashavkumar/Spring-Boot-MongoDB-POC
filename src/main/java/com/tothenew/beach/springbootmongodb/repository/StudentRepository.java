package com.tothenew.beach.springbootmongodb.repository;

import com.tothenew.beach.springbootmongodb.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
}
