package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Name_service", length = 50)
    private String nameService;

    @Column(name = "cost_service")
    private Double costService;

    @ManyToMany(mappedBy = "services")
    private Set<Student> students = new LinkedHashSet<>();
}