package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_name", length = 150)
    private String fullName;

    @Column(name = "number_chummery")
    private Integer numberChummery;

    @Column(name = "chummery_address", length = 100)
    private String chummeryAddress;

    @Column(name = "faculty", length = 50)
    private String faculty;

    @Column(name = "`group`", length = 50)
    private String group;

    @Column(name = "year")
    private Integer year;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "term_of_residence", length = 50)
    private String termOfResidence;

    @Column(name = "preferential_category", length = 50)
    private String preferentialCategory;

    @Column(name = "budget_contract", length = 50)
    private String budgetContract;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "chummery_id")
    private Chummery chummery;

}