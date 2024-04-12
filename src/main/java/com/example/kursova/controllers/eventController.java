package com.example.kursova.controllers;

import com.example.kursova.dataAO.EventStudentRepository;
import com.example.kursova.dataAO.EventsAndActivityRepository;
import com.example.kursova.dataAO.StudentRepository;
import com.example.kursova.entities.*;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class eventController {
    private EventsAndActivityRepository eventsAndActivityRepository;
    private StudentRepository studentRepository;
    private EventStudentRepository eventStudentRepository;
    @GetMapping("/enterEvent")
    public String enterEvents() {
        return "enterEvent";
    }
    @GetMapping("/event")
    public String showEvents(Model model){
        List<Event> event = eventsAndActivityRepository.findAll();
        model.addAttribute("event",event);
        return "event";
    }
    @PostMapping("/addEvent")
    public String addEvents(@RequestParam String nameEvent, @RequestParam LocalDate eventDate, @RequestParam String eventStartTime, @RequestParam String estimatesEndTime,
                             @RequestParam String venue){
       Event events= new Event();
       events.setNameEvent(nameEvent);
       events.setEventDate(eventDate);
       events.setEventStartTime(eventStartTime);
       events.setEstimatesEndTime(estimatesEndTime);
       events.setVenue(venue);
       eventsAndActivityRepository.save(events);
        return "redirect:/event";
    }
    @GetMapping("/delete_event")
    public String deleteEvent(@RequestParam int id){
        eventsAndActivityRepository.deleteById(id);
        return "redirect:/event";
    }
    @GetMapping("/edit_event")
    public String editEvent(@RequestParam int id,Model model){
        Optional<Event> optionalEvent= eventsAndActivityRepository.findById(id);
        if (optionalEvent.isEmpty()){
            return "redirect:/event";
        }
        model.addAttribute("event",optionalEvent.get());
        return "edit_event";
    }
    @PostMapping("/update_event")
    public String updateCEvent(@RequestParam int id,@RequestParam String nameEvent, @RequestParam LocalDate eventDate, @RequestParam String eventStartTime, @RequestParam String estimatesEndTime,
                               @RequestParam String venue){
        Optional<Event> optionalEvent= eventsAndActivityRepository.findById(id);
        optionalEvent.ifPresent(events -> {
            events.setNameEvent(nameEvent);
            events.setEventDate(eventDate);
            events.setEventStartTime(eventStartTime);
            events.setEstimatesEndTime(estimatesEndTime);
            events.setVenue(venue);
            eventsAndActivityRepository.save(events);
        });
        return "redirect:/event";
    }
    @GetMapping("/student_event")
    public String showStudentByEvent(@RequestParam int id, Model model){
        Optional<Event> optionalEvent= eventsAndActivityRepository.findById(id);
        if(optionalEvent.isPresent()){
            model.addAttribute("event",optionalEvent.get());
            return"event_student";
        }
        else{
            return "redirect:/event";
        }
    }
    @GetMapping("/addStudent_event")
    public String enterStudentEvent(@RequestParam int id, Model model) {
        Optional<Event> optionalEvent = eventsAndActivityRepository.findById(id);
        if (optionalEvent.isEmpty()) {
            return "redirect:/event";
        }
        model.addAttribute("event", optionalEvent.get());
        return "addStudent_event";
    }

    @PostMapping("/addStudentEvent")
    public String addStudentEvent(@RequestParam int eventId, @RequestParam int studentId, Model model) {
        Event event = eventsAndActivityRepository.findById(eventId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);

        if (event != null && student != null) {
            EventStudent existingStudentEvent = eventStudentRepository.findByStudentAndEvent(student, event);
            if (existingStudentEvent!= null) {
                return "redirect:/error";
            } else {
                // Create a new StudentService entity to represent the relationship and payment amount
                EventStudent eventStudent = new EventStudent(student,event);

                eventStudentRepository.save(eventStudent);

                return "redirect:/event";
            }
        } else {

            return "redirect:/event";
        }
    }
}
