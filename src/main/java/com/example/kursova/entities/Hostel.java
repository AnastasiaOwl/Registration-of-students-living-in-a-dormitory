package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hostel")
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "hostel_number")
    private Integer hostelNumber;

    @Column(name = "total_number_place", nullable = false)
    private Integer totalNumberPlace;

    @Column(name = "number_free_p_boys")
    private Integer numberFreePBoys;

    @Column(name = "number_free_p_girls")
    private Integer numberFreePGirls;

    @Column(name = "phone_number")
    private String phoneNumber;


}