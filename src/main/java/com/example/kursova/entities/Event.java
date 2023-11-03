package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_event", length = 50)
    private String nameEvent;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "event_start_time", length = 50)
    private String eventStartTime;

    @Column(name = "estimates_end_time", length = 50)
    private String estimatesEndTime;

    @Column(name = "venue", length = 50)
    private String venue;


    @ManyToMany
    @JoinTable(name = "event_students",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "students_id"))
    private Set<Student> students = new LinkedHashSet<>();

}