package com.example.kursova.dataAO;

import com.example.kursova.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsAndActivityRepository extends JpaRepository<Event, Integer> {
}