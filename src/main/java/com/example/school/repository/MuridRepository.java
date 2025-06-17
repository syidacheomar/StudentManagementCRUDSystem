package com.example.school.repository;

import com.example.school.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MuridRepository extends MongoRepository<Student, String> {
}
