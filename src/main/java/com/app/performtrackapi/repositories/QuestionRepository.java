package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
}
