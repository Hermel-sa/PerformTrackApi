package com.app.performtrackapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "sub_department")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sub_department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "name", unique = true)
    private String name;
}
