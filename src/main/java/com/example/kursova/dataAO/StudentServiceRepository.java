package com.example.kursova.dataAO;

import com.example.kursova.entities.Service;
import com.example.kursova.entities.Student;
import com.example.kursova.entities.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentServiceRepository extends JpaRepository<StudentService, Integer> {
    StudentService findByStudentAndService(Student student, Service service);
}