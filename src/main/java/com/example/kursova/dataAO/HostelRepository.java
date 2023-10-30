package com.example.kursova.dataAO;

import com.example.kursova.entities.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel, Integer> {
}