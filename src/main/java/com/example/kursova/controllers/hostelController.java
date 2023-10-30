package com.example.kursova.controllers;

import com.example.kursova.dataAO.HostelRepository;
import com.example.kursova.entities.Hostel;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class hostelController { //Github comment from idea Hello
    private HostelRepository hostelRepository;
    @GetMapping("/administration")
    public String administration() {
        return "Home_page";
    }
    @GetMapping("/enterChummery")
    public String enterChummery() {
        return "enterChummery";
    }
    @GetMapping("/chummery")
    public String showChummery(Model model){
        List<Hostel> chummery = hostelRepository.findAll();
        model.addAttribute("chummery",chummery);
        return "chummery";
    }
    @PostMapping("/addChummery")
    public String addChummery(@RequestParam String address,@RequestParam Integer hostelNumber, @RequestParam Integer totalNumberPlace,@RequestParam Integer numberFreePBoys, @RequestParam Integer numberFreePGirls, @RequestParam String phoneNumber){
        Hostel chummery= new Hostel();
        chummery.setAddress(address);
        chummery.setHostelNumber(hostelNumber);
        chummery.setTotalNumberPlace(totalNumberPlace);
        chummery.setNumberFreePBoys(numberFreePBoys);
        chummery.setNumberFreePGirls(numberFreePGirls);
        chummery.setPhoneNumber(phoneNumber);
        hostelRepository.save(chummery);
        return "redirect:/chummery";
    }
    @GetMapping("/student_chummery")
    public String showStudentByChummery(@RequestParam int id, Model model){
        Optional<Hostel> optionalChummery= hostelRepository.findById(id);
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
       hostelRepository.deleteById(id);
       return "redirect:/chummery";
    }
    @GetMapping("/edit_chummery")
    public String editChummery(@RequestParam int id,Model model){
        Optional<Hostel> optionalChummery= hostelRepository.findById(id);
        if (optionalChummery.isEmpty()){
            return "redirect:/chummery";
        }
        model.addAttribute("chummery",optionalChummery.get());
        return "edit_chummery";
    }
    @PostMapping("/update_chummery")
    public String updateChummery(@RequestParam int id,@RequestParam String address,@RequestParam Integer hostelNumber,@RequestParam Integer totalNumberPlace, @RequestParam Integer numberFreePBoys,
                                 @RequestParam Integer numberFreePGirls, @RequestParam String phoneNumber){
        Optional<Hostel> optionalChummery= hostelRepository.findById(id);
        optionalChummery.ifPresent(chummery -> {
            chummery.setAddress(address);
            chummery.setHostelNumber(hostelNumber);
            chummery.setTotalNumberPlace(totalNumberPlace);
            chummery.setNumberFreePBoys(numberFreePBoys);
            chummery.setNumberFreePGirls(numberFreePGirls);
            chummery.setPhoneNumber(phoneNumber);
            hostelRepository.save(chummery);
        });
        return "redirect:/chummery";
    }
}
