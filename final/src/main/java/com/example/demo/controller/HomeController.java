package com.example.demo.controller;

import com.example.demo.service.PatientService;
import com.example.demo.service.SomnographyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final PatientService patientService;
    private final SomnographyService somnographyService;

    public HomeController(PatientService patientService, SomnographyService somnographyService) {
        this.patientService = patientService;
        this.somnographyService = somnographyService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patientCount", patientService.count());
        model.addAttribute("somnographyCount", somnographyService.count());
        model.addAttribute("finishedSomnographyCount", somnographyService.countByStatus("Finalizada"));
        model.addAttribute("upcomingStudyCount", somnographyService.countUpcomingStudies());
        return "index";
    }
}