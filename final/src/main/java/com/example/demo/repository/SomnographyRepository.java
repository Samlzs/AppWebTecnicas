package com.example.demo.repository;

import com.example.demo.model.Somnography;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SomnographyRepository extends JpaRepository<Somnography, Long> {

    List<Somnography> findAllByOrderByStudyDateDesc();

    long countByStatus(String status);

    List<Somnography> findByScheduledDateIsNotNullAndStatusNotInOrderByScheduledDateAscScheduledTimeAsc(
            List<String> statuses
    );

    long countByScheduledDateGreaterThanEqualAndStatusNotIn(
            LocalDate date,
            List<String> statuses
    );
}