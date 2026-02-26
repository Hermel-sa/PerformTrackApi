package com.app.performtrackapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String period;

    private LocalDate date;

    private String edition;

    private String revision;
}
