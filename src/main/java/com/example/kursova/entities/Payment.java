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

    @Column(name = "last_payment_date")
    private LocalDate lastPaymentDate;

    @Column(name = "fix_payment_date")
    private LocalDate fixPaymentDate;

    @Column(name = "amount_of_last_payment")
    private Double amountOfLastPayment;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "fixed_amount")
    private Double fixedAmount;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student; // Reference to the associated student
}