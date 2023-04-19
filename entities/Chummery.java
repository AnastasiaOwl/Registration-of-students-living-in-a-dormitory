package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "chummery")
public class Chummery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "chummery_number")
    private Integer chummeryNumber;

    @Column(name = "q_rooms")
    private Integer quRooms;

    @Column(name = "boys_r_numbers")
    private Integer boysRNumbers;

    @Column(name = "girls_r_numbers")
    private Integer girlsRNumbers;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "chummery", orphanRemoval = true)
    private Set<Student> students = new LinkedHashSet<>();

}