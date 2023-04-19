package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fullName", length = 150)
    private String fullName;

    @Column(name = "lastPaymentDate")
    private LocalDate lastPaymentDate;

    @Column(name = "fixDate")
    private LocalDate fixDate;

    @Column(name = "paymentAmount")
    private Double paymentAmount;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private Student student;

}