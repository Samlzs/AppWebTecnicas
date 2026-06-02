package com.example.demo.service;

import com.example.demo.model.Somnography;
import com.example.demo.repository.SomnographyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class SomnographyService {

    private final SomnographyRepository somnographyRepository;

    public SomnographyService(SomnographyRepository somnographyRepository) {
        this.somnographyRepository = somnographyRepository;
    }

    @Transactional(readOnly = true)
    public List<Somnography> findAllOrdered() {
        return somnographyRepository.findAllByOrderByStudyDateDesc();
    }

    @Transactional(readOnly = true)
    public Somnography findById(Long id) {
        return somnographyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Somnografia no encontrada"));
    }

    @Transactional(readOnly = true)
    public List<Somnography> findScheduledStudies() {
        return somnographyRepository
                .findByScheduledDateIsNotNullAndStatusNotInOrderByScheduledDateAscScheduledTimeAsc(
                        Arrays.asList("Finalizada", "Anulada")
                );
    }

    @Transactional(readOnly = true)
    public long countUpcomingStudies() {
        return somnographyRepository.countByScheduledDateGreaterThanEqualAndStatusNotIn(
                LocalDate.now(),
                Arrays.asList("Finalizada", "Anulada")
        );
    }

    @Transactional(readOnly = true)
    public long count() {
        return somnographyRepository.count();
    }

    @Transactional(readOnly = true)
    public long countByStatus(String status) {
        return somnographyRepository.countByStatus(status);
    }   

    @Transactional
    public Somnography save(Somnography somnography) {
        return somnographyRepository.save(somnography);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!somnographyRepository.existsById(id)) {
            throw new IllegalArgumentException("Somnografia no encontrada");
        }
        somnographyRepository.deleteById(id);
    }
}
