package com.app.performtrackapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "position")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(optional = true)
    @JoinColumn(name = "subdepartment_id", nullable = true)
    private Sub_department subDepartment;

    @Column(name = "name", unique = true)
    private String name;
}
