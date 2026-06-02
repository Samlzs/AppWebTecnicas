package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "somnographies")
public class Somnography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "somnography_id")
    private Long somnographyId;

    @NotNull(message = "Selecciona un paciente")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull(message = "La fecha del estudio es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "study_date", nullable = false)
    private LocalDate studyDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "scheduled_date")
    private LocalDate scheduledDate;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "scheduled_time")
    private LocalTime scheduledTime;

    @NotBlank(message = "El tipo de estudio es obligatorio")
    @Size(max = 80, message = "El tipo de estudio no puede superar 80 caracteres")
    @Column(name = "study_type", nullable = false, length = 80)
    private String studyType;

    @Size(max = 1000, message = "Las observaciones no pueden superar 1000 caracteres")
    @Column(name = "observations", length = 1000)
    private String observations;

    @NotBlank(message = "El resultado es obligatorio")
    @Size(max = 1000, message = "El resultado no puede superar 1000 caracteres")
    @Column(name = "result", nullable = false, length = 1000)
    private String result;

    @NotBlank(message = "El estado es obligatorio")
    @Size(max = 40, message = "El estado no puede superar 40 caracteres")
    @Column(name = "status", nullable = false, length = 40)
    private String status = "Registrada";

    public Long getSomnographyId() {
        return somnographyId;
    }

    public void setSomnographyId(Long somnographyId) {
        this.somnographyId = somnographyId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDate getStudyDate() {
        return studyDate;
    }

    public void setStudyDate(LocalDate studyDate) {
        this.studyDate = studyDate;
    }

    public LocalDate getScheduledDate() {
    return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public LocalTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getStudyType() {
        return studyType;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
