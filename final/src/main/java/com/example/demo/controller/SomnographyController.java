package com.example.demo.controller;

import com.example.demo.model.Somnography;
import com.example.demo.service.PatientService;
import com.example.demo.service.SomnographyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/somnographies")
public class SomnographyController {

    private final SomnographyService somnographyService;
    private final PatientService patientService;

    public SomnographyController(SomnographyService somnographyService, PatientService patientService) {
        this.somnographyService = somnographyService;
        this.patientService = patientService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("somnographies", somnographyService.findAllOrdered());
        return "somnographies/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("somnography", new Somnography());
        loadFormData(model, "Registrar somnografia");
        return "somnographies/form";
    }

    @PostMapping
    public String save(
            @Valid @ModelAttribute Somnography somnography,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            loadFormData(model, somnography.getSomnographyId() == null ? "Registrar somnografia" : "Editar somnografia");
            return "somnographies/form";
        }

        somnographyService.save(somnography);
        redirectAttributes.addFlashAttribute("success", "Somnografia guardada correctamente");
        return "redirect:/somnographies";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("somnography", somnographyService.findById(id));
            return "somnographies/detail";
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            return "redirect:/somnographies";
        }
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("somnography", somnographyService.findById(id));
            loadFormData(model, "Editar somnografia");
            return "somnographies/form";
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            return "redirect:/somnographies";
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            somnographyService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Somnografia eliminada correctamente");
        } catch (IllegalArgumentException exception) {
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
        }
        return "redirect:/somnographies";
    }

    private void loadFormData(Model model, String title) {
        model.addAttribute("patients", patientService.findAllOrdered());
        model.addAttribute("title", title);
    }
}
