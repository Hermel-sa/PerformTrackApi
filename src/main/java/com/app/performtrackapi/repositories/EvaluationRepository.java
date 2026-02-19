package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, UUID> {
    Evaluation findByPositionId(UUID positionId);
}
