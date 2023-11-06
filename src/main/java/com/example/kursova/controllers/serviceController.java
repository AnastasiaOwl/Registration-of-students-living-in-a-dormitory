package com.example.kursova.controllers;
import com.example.kursova.dataAO.ServiceRepository;
import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.dataAO.StudentServiceRepository;
import com.example.kursova.entities.Service;
import com.example.kursova.entities.Student;
import com.example.kursova.entities.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class serviceController {
    private ServiceRepository serviceRepository;
    private StudentRepository studentRepository;
    private StudentServiceRepository studentServiceRepository;

    @GetMapping("/enterService")
    public String enterService() {
        return "enterService";
    }

    @GetMapping("/service")
    public String showStudent(Model model) {
        List<Service> service = serviceRepository.findAll();
        model.addAttribute("service", service);
        return "/service";
    }

    @PostMapping("/addService")
    public String addService(@RequestParam String nameService, @RequestParam double costService) {
        Service service = new Service();
        service.setNameService(nameService);
        service.setCostService(costService);
        serviceRepository.save(service);
        return "redirect:/service";
    }

    @GetMapping("/delete_service")
    public String deleteService(@RequestParam int id) {
        serviceRepository.deleteById(id);
        return "redirect:/service";
    }

    @GetMapping("/edit_service")
    public String editService(@RequestParam int id, Model model) {
        Optional<Service> optionalService = serviceRepository.findById(id);
        if (optionalService.isEmpty()) {
            return "redirect:/service";
        }
        model.addAttribute("service", optionalService.get());
        return "edit_service";
    }

    @PostMapping("/update_service")
    public String updateService(@RequestParam int id, @RequestParam String nameService, @RequestParam double costService) {
        Optional<Service> optionalService = serviceRepository.findById(id);
        optionalService.ifPresent(service -> {
            service.setNameService(nameService);
            service.setCostService(costService);
            serviceRepository.save(service);
        });
        return "redirect:/service";
    }

    @GetMapping("/student_service")
    public String showStudentByService(@RequestParam int id, Model model) {
        Optional<Service> optionalService = serviceRepository.findById(id);
        if (optionalService.isPresent()) {
            model.addAttribute("service", optionalService.get());
            return "service_student";
        } else {
            return "redirect:/service";
        }
    }

    @GetMapping("/payment_service")
    public String enterPayment(@RequestParam int id, Model model) {
            Optional<Service> optionalService = serviceRepository.findById(id);
            if (optionalService.isEmpty()) {
                return "redirect:/service";
            }
            model.addAttribute("service", optionalService.get());
        return "payment_service";
    }

//    @PostMapping("/addStudentPayment")
//    public String addStudentPayment(
//            @RequestParam int serviceId,
//            @RequestParam int studentId,
//            @RequestParam double paymentAmount
//    ) {
//        // Retrieve the selected service and student based on their IDs
//        Service service = serviceRepository.findById(serviceId).orElse(null);
//        Student student = studentRepository.findById(studentId).orElse(null);
//
//        // Check if the service and student exist
//        if (service != null && student != null) {
//            // Check if the student is already associated with the service
//            StudentService existingStudentService = studentServiceRepository.findByStudentAndService(student, service);
//            if (existingStudentService != null) {
//                // Handle the case where the student is already associated with the service.
//                // You can return an error message or redirect to an error page.
//                return "redirect:/error";
//            } else {
//                // Create a new StudentService entity to represent the relationship and payment amount
//                StudentService studentService = new StudentService(student, service, paymentAmount);
//
//                // Save the StudentService entity to the database
//                studentServiceRepository.save(studentService);
//
//                return "redirect:/service";
//            }
//        } else {
//            // Handle the case where the service or student is not found.
//            // You can return an error message or redirect to an error page.
//            return "redirect:/error";
//        }
//    }


}
