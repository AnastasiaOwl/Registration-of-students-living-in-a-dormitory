package com.example.kursova.controllers;

import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.entities.Hostel;
import com.example.kursova.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class studentController {
    private StudentRepository studentRepository;

    @GetMapping("/enterStudent")
    public String enterPayment() {
        return "enterStudent";
    }

    @GetMapping("/student")
        public String showStudent(Model model){
        List<Student> student = studentRepository.findAll();
        model.addAttribute("student",student);
        return "/student";
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String nameResident, @RequestParam String nameFaculty, @RequestParam String group, @RequestParam Integer year,
                             @RequestParam String roomNumber, @RequestParam LocalDate dateSettlement, @RequestParam LocalDate dateEviction,  @RequestParam String preferentialCategory, @RequestParam String budgetContract, @RequestParam String residenceStatus ){
       Student student = new Student();
        student.setNameResident(nameResident);
        student.setNameFaculty(nameFaculty);
        student.setGroup(group);
        student.setYear(year);
        student.setRoomNumber(roomNumber);
        student.setDateSettlement(dateSettlement);
        student.setDateEviction(dateEviction);
        student.setPreferentialCategory(preferentialCategory);
        student.setBudgetContract(budgetContract);
        student.setResidenceStatus(residenceStatus);
        studentRepository.save(student);
        return "redirect:/student";
    }
    @GetMapping("/edit_student")
    public String editStudent(@RequestParam int id,Model model){
        Optional<Student> optionalStudent= studentRepository.findById(id);
        if (optionalStudent.isEmpty()){
            return "redirect:/student";
        }
        model.addAttribute("student",optionalStudent.get());
        return "edit_student";
    }
    @PostMapping("/update_student")
    public String updateStudent(@RequestParam int id,@RequestParam String nameResident,@RequestParam String nameFaculty,@RequestParam String group, @RequestParam Integer year, @RequestParam String roomNumber,
                                @RequestParam LocalDate dateSettlement,@RequestParam LocalDate dateEviction,@RequestParam String preferentialCategory,@RequestParam String budgetContract,@RequestParam String residenceStatus){
       Optional<Student> optionalStudent= studentRepository.findById(id);
        optionalStudent.ifPresent(student -> {
            student.setNameResident(nameResident);
            student.setNameFaculty(nameFaculty);
            student.setGroup(group);
            student.setYear(year);
            student.setRoomNumber(roomNumber);
            student.setDateSettlement(dateSettlement);
            student.setDateEviction(dateEviction);
            student.setPreferentialCategory(preferentialCategory);
            student.setBudgetContract(budgetContract);
            student.setResidenceStatus(residenceStatus);
            studentRepository.save(student);
        });
        return "redirect:/student";
    }
    @GetMapping("/room_student")
    public String showRoomByStudent(@RequestParam int id, Model model){
        Optional<Student> optionalStudent= studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            model.addAttribute("student",optionalStudent.get());
            return"student_room";
        }
        else{
            return "redirect:/student";
        }
    }
}
