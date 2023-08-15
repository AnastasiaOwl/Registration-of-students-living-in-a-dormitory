package com.example.kursova.controllers;

import com.example.kursova.dataAO.ChummeryRepository;
import com.example.kursova.entities.Chummery;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class chummeryController { //Github commentary
    private ChummeryRepository chummeryRepository;
    @GetMapping("/administration")
    public String administration() {
        return "administration";
    }
    @GetMapping("/enterChummery")
    public String enterChummery() {
        return "enterChummery";
    }
    @GetMapping("/chummery")
    public String showChummery(Model model){
        List<Chummery> chummery = chummeryRepository.findAll();
        model.addAttribute("chummery",chummery);
        return "chummery";
    }
    @PostMapping("/addChummery")
    public String addPayment(@RequestParam String address,@RequestParam Integer chummeryNumber, @RequestParam Integer quRooms,@RequestParam Integer boysRNumbers, @RequestParam Integer girlsRNumbers, @RequestParam String phoneNumber){
        Chummery chummery= new Chummery();
        chummery.setAddress(address);
        chummery.setChummeryNumber(chummeryNumber);
        chummery.setQuRooms(quRooms);
        chummery.setBoysRNumbers(boysRNumbers);
        chummery.setGirlsRNumbers(girlsRNumbers);
        chummery.setPhoneNumber(phoneNumber);
        chummeryRepository.save(chummery);
        return "redirect:/enterChummery";
    }
    @GetMapping("/student_chummery")
    public String showStudentByChummery(@RequestParam int id, Model model){
        Optional<Chummery> optionalChummery=chummeryRepository.findById(id);
        if(optionalChummery.isPresent()){
            model.addAttribute("chummery",optionalChummery.get());
            return"chummery_student";
        }
        else{
            return "redirect:/chummery";
        }
    }
    @GetMapping("/delete_chummery")
    public String deleteChummery(@RequestParam int id){
       chummeryRepository.deleteById(id);
       return "redirect:/chummery";
    }
    @GetMapping("/edit_chummery")
    public String editChummery(@RequestParam int id,Model model){
        Optional<Chummery> optionalChummery= chummeryRepository.findById(id);
        if (optionalChummery.isEmpty()){
            return "redirect:/chummery";
        }
        model.addAttribute("chummery",optionalChummery.get());
        return "edit_chummery";
    }
    @PostMapping("/update_chummery")
    public String updateChummery(@RequestParam int id,@RequestParam String address,@RequestParam Integer chummeryNumber,@RequestParam Integer quRooms, @RequestParam Integer boysRNumbers,
                                 @RequestParam Integer girlsRNumbers, @RequestParam String phoneNumber){
        Optional<Chummery> optionalChummery= chummeryRepository.findById(id);
        optionalChummery.ifPresent(chummery -> {
        chummery.setAddress(address);
        chummery.setChummeryNumber(chummeryNumber);
        chummery.setQuRooms(quRooms);
        chummery.setBoysRNumbers(boysRNumbers);
        chummery.setGirlsRNumbers(girlsRNumbers);
        chummery.setPhoneNumber(phoneNumber);
            chummeryRepository.save(chummery);
        });
        return "redirect:/chummery";
    }
}
