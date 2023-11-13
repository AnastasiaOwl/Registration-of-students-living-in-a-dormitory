package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_events")
public class EventStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "events_id")
    private Event event;


    public EventStudent(Student students, Event event) {
        this.student = students;
        this.event = event;
    }

    public EventStudent() {

    }
}