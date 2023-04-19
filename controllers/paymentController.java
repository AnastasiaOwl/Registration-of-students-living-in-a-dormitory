package com.example.kursova.controllers;

import com.example.kursova.dataAO.PaymentRepository;
import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.entities.Payment;
import com.example.kursova.entities.Student;
import lombok.AllArgsConstructor;;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class paymentController {
    private PaymentRepository paymentRepository;
    @GetMapping("/accountant")
    public String accountant() {
        return "accountant";
    }
    @GetMapping("/enterPayment")
    public String enterPayment() {
        return "enterPayment";
    }
    @GetMapping("/payment")
    public String getAllPayment(Model model) {
        List<Payment> payment =paymentRepository.findAll();
        model.addAttribute("payment",payment);
        return "payment";
    }
    @PostMapping("/addPayment")
    public String addPayment(@RequestParam String fullName, @RequestParam LocalDate dateOfTheLastPayment, @RequestParam LocalDate fixedDate,@RequestParam double sum){
        Payment payment= new Payment();
        payment.setFullName(fullName);
        payment.setLastPaymentDate(dateOfTheLastPayment);
        payment.setFixDate(fixedDate);
        payment.setPaymentAmount(sum);
        paymentRepository.save(payment);
        return "redirect:/enterPayment";
    }
    @GetMapping("/payment_student")
    public String showStudentByPayment(@RequestParam int id, Model model){
       Optional<Payment> optionalPayment= paymentRepository.findById(id);
       if(optionalPayment.isPresent()){
           model.addAttribute("payment",optionalPayment.get());
           return"student_payment";
       }
       else{
         return "redirect:/payment";
       }
    }
    @GetMapping("/delete_payment")
    public String deletePayment(@RequestParam int id){
        paymentRepository.deleteById(id);
        return "redirect:/payment";
    }

    @GetMapping("/edit_payment")
    public String editPayment(@RequestParam int id,Model model){
        Optional<Payment> optionalPayment= paymentRepository.findById(id);
        if (optionalPayment.isEmpty()){
            return "redirect:/payment";
        }
        model.addAttribute("payment",optionalPayment.get());
        return "edit_payment";
    }
    @PostMapping("/update_payment")
    public String updatePayment(@RequestParam int id,@RequestParam String fullName, @RequestParam LocalDate lastPaymentDate,@RequestParam LocalDate fixDate, @RequestParam Double paymentAmount){
        Optional<Payment> optionalPayment= paymentRepository.findById(id);
        optionalPayment.ifPresent(payment -> {
            payment.setFullName(fullName);
            payment.setLastPaymentDate(lastPaymentDate);
            payment.setFixDate(fixDate);
            payment.setPaymentAmount(paymentAmount);
            paymentRepository.save(payment);
        });
        return "redirect:/payment";
    }
}
