package com.example.demo.controller;

import com.example.demo.service.SomnographyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgendaController {

    private final SomnographyService somnographyService;

    public AgendaController(SomnographyService somnographyService) {
        this.somnographyService = somnographyService;
    }

    @GetMapping("/agenda")
    public String agenda(Model model) {
        model.addAttribute("scheduledStudies", somnographyService.findScheduledStudies());
        return "agenda/list";
    }
}