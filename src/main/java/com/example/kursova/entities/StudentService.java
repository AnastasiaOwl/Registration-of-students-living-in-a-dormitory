package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student_services")
public class StudentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(name = "payment_amount")
    private double paymentAmount;

    public StudentService() {
    }

    public StudentService(Student student, Service service, double paymentAmount) {
        this.student = student;
        this.service = service;
        this.paymentAmount = paymentAmount;
    }
}