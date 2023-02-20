package pcrc.gotbetter.plan_evaluation.data_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pcrc.gotbetter.plan_evaluation.data_access.entity.PlanEvaluation;
import pcrc.gotbetter.plan_evaluation.data_access.entity.PlanEvaluationId;

import java.util.List;

@Repository
public interface PlanEvaluationRepository extends JpaRepository<PlanEvaluation, PlanEvaluationId>, PlanEvaluationRepositoryQueryDSL {
    List<PlanEvaluation> findByPlanEvaluationIdPlanId(Long plan_id);
    void deleteByPlanEvaluationIdPlanId(Long plan_id);
    void deleteByPlanEvaluationId(PlanEvaluationId planEvaluationId);
}
