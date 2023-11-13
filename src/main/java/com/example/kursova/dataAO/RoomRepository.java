package com.example.kursova.dataAO;

import com.example.kursova.entities.Hostel;
import com.example.kursova.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByHostel(Hostel hostel);
}