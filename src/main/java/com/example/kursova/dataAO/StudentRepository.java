package com.example.kursova.dataAO;

import com.example.kursova.entities.Room;
import com.example.kursova.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByRoom(Room room);
}