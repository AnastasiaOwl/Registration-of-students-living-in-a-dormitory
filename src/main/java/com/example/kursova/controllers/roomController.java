package com.example.kursova.controllers;

import com.example.kursova.dataAO.RoomRepository;
import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.entities.Room;
import com.example.kursova.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class roomController {
    private RoomRepository roomRepository;
    @GetMapping("/enterRoom")
    public String enterPayment() {
        return "enterRoom";
    }
    @GetMapping("/room")
    public String showRoom(Model model){
        List<Room> room = roomRepository.findAll();
        model.addAttribute("room",room);
        return "/room";
    }
    @PostMapping("/addRoom")
    public String addRoom(@RequestParam String roomNumber, @RequestParam String freeBusy, @RequestParam String roomType, @RequestParam double costAccommodation){
        Room room = new Room();
       room.setRoomNumber(roomNumber);
       room.setFreeBusy(freeBusy);
       room.setRoomType(roomType);
       room.setCostAccommodation(costAccommodation);
        roomRepository.save(room);
        return "redirect:/room";
    }
    @GetMapping("/delete_room")
    public String deleteRoom(@RequestParam int id){
        //TODO Confirmation for delete
        roomRepository.deleteById(id);
        return "redirect:/room";
    }
    @GetMapping("/edit_room")
    public String editRoom(@RequestParam int id,Model model){
        Optional<Room> optionalRoom= roomRepository.findById(id);
        if (optionalRoom.isEmpty()){
            return "redirect:/room";
        }
        model.addAttribute("room",optionalRoom.get());
        return "edit_room";
    }
    @PostMapping("/update_room")
    public String updateRoom(@RequestParam int id,@RequestParam String roomNumber,@RequestParam String freeBusy,@RequestParam String roomType, @RequestParam double costAccommodation){
        Optional<Room> optionalRoom= roomRepository.findById(id);
        optionalRoom.ifPresent(room -> {
            room.setRoomNumber(roomNumber);
            room.setFreeBusy(freeBusy);
            room.setRoomType(roomType);
            room.setCostAccommodation(costAccommodation);
            roomRepository.save(room);
        });
        return "redirect:/room";
    }
    @GetMapping("/chummery_room")
    public String showChummeryByRoom(@RequestParam int id, Model model){
        Optional<Room> optionalRoom= roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            model.addAttribute("room",optionalRoom.get());
            return"room_chummery";
        }
        else{
            return "redirect:/room";
        }
    }
}
