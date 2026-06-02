package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        model.addAttribute("patients", patientService.search(keyword));
        model.addAttribute("keyword", keyword);
        return "patients/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("title", "Registrar paciente");
        return "patients/form";
    }

    @PostMapping
    public String save(
            @Valid @ModelAttribute Patient patient,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", patient.getPatientId() == null ? "Registrar paciente" : "Editar paciente");
            return "patients/form";
        }

        try {
            patientService.save(patient);
            redirectAttributes.addFlashAttribute("success", "Paciente guardado correctamente");
            return "redirect:/patients";
        } catch (IllegalArgumentException exception) {
            bindingResult.rejectValue("document", "document.duplicate", exception.getMessage());
            model.addAttribute("title", patient.getPatientId() == null ? "Registrar paciente" : "Editar paciente");
            return "patients/form";
        }
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("patient", patientService.findById(id));
            return "patients/detail";
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            return "redirect:/patients";
        }
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("patient", patientService.findById(id));
            model.addAttribute("title", "Editar paciente");
            return "patients/form";
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            return "redirect:/patients";
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            patientService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Paciente eliminado correctamente");
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
        }
        return "redirect:/patients";
    }
}
