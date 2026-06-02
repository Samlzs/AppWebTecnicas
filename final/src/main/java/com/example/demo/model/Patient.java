package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80, message = "El nombre no puede superar 80 caracteres")
    @Column(name = "patient_name", nullable = false, length = 80)
    private String patientName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 80, message = "El apellido no puede superar 80 caracteres")
    @Column(name = "patient_lastname", nullable = false, length = 80)
    private String patientLastname;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 30, message = "El documento no puede superar 30 caracteres")
    @Column(name = "document", nullable = false, unique = true, length = 30)
    private String document;

    @Pattern(regexp = "^[0-9]{10}$", message = "El telefono debe tener exactamente 10 numeros")
    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Ingresa un correo valido")
    @Size(max = 120, message = "El correo no puede superar 120 caracteres")
    @Column(name = "email", nullable = false, length = 120)
    private String email;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser anterior a hoy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Somnography> somnographies = new ArrayList<>();

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Somnography> getSomnographies() {
        return somnographies;
    }

    public void setSomnographies(List<Somnography> somnographies) {
        this.somnographies = somnographies;
    }

    public String getFullName() {
        return patientName + " " + patientLastname;
    }
}
