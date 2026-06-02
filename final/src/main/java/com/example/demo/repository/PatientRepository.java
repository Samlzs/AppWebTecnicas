package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByDocument(String document);

    boolean existsByDocumentAndPatientIdNot(String document, Long patientId);

    List<Patient> findByDocumentContainingIgnoreCaseOrPatientNameContainingIgnoreCaseOrderByPatientNameAsc(
            String document,
            String patientName
    );

    List<Patient> findAllByOrderByPatientNameAscPatientLastnameAsc();
}
