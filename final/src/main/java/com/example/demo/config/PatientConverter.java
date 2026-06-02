package com.example.demo.config;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PatientConverter implements Converter<String, Patient> {

    private final PatientService patientService;

    public PatientConverter(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public Patient convert(String source) {
        if (source == null || source.isBlank()) {
            return null;
        }
        return patientService.findById(Long.valueOf(source));
    }
}
