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
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class paymentController {
    private PaymentRepository paymentRepository;
    private final StudentRepository studentRepository;

    @GetMapping("/enterPayment")
    public String enterPayment() {
        return "enterPayment";
    }

    @GetMapping("/payment")
    public String getAllPayment(Model model) {
        List<Payment> payment = paymentRepository.findAll();
        model.addAttribute("payment", payment);
        return "payment";
    }

    @PostMapping("/addPayment")
    public String addPayment(@RequestParam LocalDate lastPaymentDate, @RequestParam LocalDate fixPaymentDate,
                             @RequestParam double amountOfLastPayment, @RequestParam double totalAmount, @RequestParam double fixedAmount,@RequestParam("student_id") Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            Payment payment = new Payment();
            payment.setLastPaymentDate(lastPaymentDate);
            payment.setFixPaymentDate(fixPaymentDate);
            payment.setAmountOfLastPayment(amountOfLastPayment);
            payment.setTotalAmount(totalAmount);
            payment.setFixedAmount(fixedAmount);
            payment.setStudent(student);
            paymentRepository.save(payment);
        }
        return "redirect:/payment";
    }

    @GetMapping("/delete_payment")
    public String deletePayment(@RequestParam int id) {
        paymentRepository.deleteById(id);
        return "redirect:/payment";
    }

    @GetMapping("/edit_payment")
    public String editPayment(@RequestParam int id, Model model) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isEmpty()) {
            return "redirect:/payment";
        }
        model.addAttribute("payment", optionalPayment.get());
        return "edit_payment";
    }

    @PostMapping("/update_payment")
    public String updatePayment(@RequestParam int id, @RequestParam LocalDate lastPaymentDate, @RequestParam LocalDate fixPaymentDate,
                                @RequestParam double amountOfLastPayment, @RequestParam double totalAmount, @RequestParam double fixedAmount){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        optionalPayment.ifPresent(payment -> {
            payment.setLastPaymentDate(lastPaymentDate);
            payment.setFixPaymentDate(fixPaymentDate);
            payment.setAmountOfLastPayment(amountOfLastPayment);
            payment.setTotalAmount(totalAmount);
            payment.setFixedAmount(fixedAmount);
            paymentRepository.save(payment);
        });
        return "redirect:/payment";
    }
}
