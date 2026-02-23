package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Category;
import com.app.performtrackapi.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    int countByEvaluation(Evaluation evaluation);

    @Query("SELECT c FROM Category c WHERE c.evaluation = :evaluation ORDER BY c.order_index ASC, c.id ASC")
    List<Category> findByEvaluationOrderByOrderIndexAsc(@Param("evaluation") Evaluation evaluation);
}
