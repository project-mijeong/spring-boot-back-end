package pcrc.gotbetter.plan_evaluation.ui.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import pcrc.gotbetter.plan_evaluation.service.PlanEvaluationReadUseCase;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlanEvaluationView {
    private final Integer dislike_count;
    private final Boolean checked;

    @Builder
    public PlanEvaluationView(PlanEvaluationReadUseCase.FindPlanEvaluationResult planEvaluationResult) {
        this.dislike_count = planEvaluationResult.getDislike_count();
        this.checked = planEvaluationResult.getChecked();
    }
}
