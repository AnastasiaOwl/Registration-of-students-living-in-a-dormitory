package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_resident", length = 150)
    private String nameResident;

    @Column(name = "name_faculty", length = 50)
    private String nameFaculty;

    @Column(name = "`group`", length = 50)
    private String group;

    @Column(name = "year")
    private Integer year;

    @Column(name = "room_number", length = 50)
    private String roomNumber;

    @Column(name = "date_settlement")
    private LocalDate dateSettlement;

    @Column(name = "date_eviction")
    private LocalDate dateEviction;

    @Column(name = "preferential_category", length = 50)
    private String preferentialCategory;

    @Column(name = "budget_contract", length = 50)
    private String budgetContract;

    @Column(name = "residence_status", length = 50)
    private String residenceStatus;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}