package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional(readOnly = true)
    public List<Patient> findAllOrdered() {
        return patientRepository.findAllByOrderByPatientNameAscPatientLastnameAsc();
    }

    @Transactional(readOnly = true)
    public List<Patient> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAllOrdered();
        }
        String cleanKeyword = keyword.trim();
        return patientRepository
                .findByDocumentContainingIgnoreCaseOrPatientNameContainingIgnoreCaseOrderByPatientNameAsc(
                        cleanKeyword,
                        cleanKeyword
                );
    }

    @Transactional(readOnly = true)
    public Patient findById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado"));
    }

    @Transactional(readOnly = true)
    public long count() {
        return patientRepository.count();
    }

    @Transactional
    public Patient save(Patient patient) {
        boolean documentExists = patient.getPatientId() == null
                ? patientRepository.existsByDocument(patient.getDocument())
                : patientRepository.existsByDocumentAndPatientIdNot(patient.getDocument(), patient.getPatientId());

        if (documentExists) {
            throw new IllegalArgumentException("Ya existe un paciente con ese documento");
        }

        return patientRepository.save(patient);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        patientRepository.deleteById(id);
    }
}
