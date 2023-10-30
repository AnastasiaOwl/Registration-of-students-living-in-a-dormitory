package com.example.kursova.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "room_number", length = 50)
    private String roomNumber;

    @Column(name = "`free/busy`", length = 50)
    private String freeBusy;

    @Column(name = "room_type", length = 50)
    private String roomType;

    @Column(name = "cost_accommodation")
    private Double costAccommodation;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;

}
