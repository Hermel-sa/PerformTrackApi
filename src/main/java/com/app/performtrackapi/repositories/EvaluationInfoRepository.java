package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.EvaluationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EvaluationInfoRepository extends JpaRepository<EvaluationInfo, UUID> {
}
