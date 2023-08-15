package com.example.kursova.controllers;

import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.entities.Student;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class studentController {
    private StudentRepository studentRepository;
    @GetMapping("/employees")
    public String accountant() {
        return "employees";
    }
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
    public String addStudent(@RequestParam String fullName, @RequestParam Integer numberChummery, @RequestParam String chummeryAddress, @RequestParam String faculty,
                             @RequestParam String group,@RequestParam Integer year, @RequestParam Integer roomNumber, @RequestParam String termOfResidence, @RequestParam String preferentialCategory,@RequestParam String budgetContract ){
       Student student = new Student();
        student.setFullName(fullName);
        student.setNumberChummery( numberChummery);
        student.setChummeryAddress(chummeryAddress);
        student.setFaculty(faculty);
        student.setGroup(group);
        student.setYear(year);
        student.setRoomNumber(roomNumber);
        student.setTermOfResidence(termOfResidence);
        student.setPreferentialCategory(preferentialCategory);
        student.setBudgetContract(budgetContract);
        studentRepository.save(student);
        return "redirect:/enterStudent";
    }
    @GetMapping("/delete_student")
    public String deleteStudent(@RequestParam int id){
        //TODO Confirmation for delete
        studentRepository.deleteById(id);
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
    public String updateStudent(@RequestParam int id,@RequestParam String fullName,@RequestParam Integer numberChummery,@RequestParam String chummeryAddress,@RequestParam String faculty,@RequestParam String group,
                                @RequestParam Integer year, @RequestParam Integer roomNumber,@RequestParam String termOfResidence,@RequestParam String preferentialCategory,@RequestParam String budgetContract){
       Optional<Student> optionalStudent= studentRepository.findById(id);
        optionalStudent.ifPresent(student -> {
            student.setFullName(fullName);
            student.setNumberChummery(numberChummery);
            student.setChummeryAddress(chummeryAddress);
            student.setFaculty(faculty);
            student.setGroup(group);
            student.setYear(year);
            student.setRoomNumber(roomNumber);
            student.setTermOfResidence(termOfResidence);
            student.setPreferentialCategory(preferentialCategory);
            student.setBudgetContract(budgetContract);
            studentRepository.save(student);
        });
        return "redirect:/student";
    }
}
