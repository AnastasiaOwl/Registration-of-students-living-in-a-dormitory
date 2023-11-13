package com.example.kursova.dataAO;

import com.example.kursova.entities.Event;
import com.example.kursova.entities.EventStudent;
import com.example.kursova.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventStudentRepository extends JpaRepository<EventStudent, Integer> {
    EventStudent findByStudentAndEvent(Student student, Event event);
}