package com.example.kursova.dataAO;

import com.example.kursova.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}