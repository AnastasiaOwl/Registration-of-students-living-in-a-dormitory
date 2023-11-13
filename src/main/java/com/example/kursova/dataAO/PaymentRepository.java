package com.example.kursova.dataAO;

import com.example.kursova.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query("SELECT p FROM Payment p JOIN FETCH p.student")
    List<Payment> findAllWithStudent();
}