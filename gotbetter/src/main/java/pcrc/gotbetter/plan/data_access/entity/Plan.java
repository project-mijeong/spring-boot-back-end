package pcrc.gotbetter.plan.data_access.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Entity
@Table(name = "Plan")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "target_date")
    private LocalDate targetDate;
    @Column(name = "score")
    private Float score;
    private Integer week;
    @Column(name = "three_days_passed")
    private Boolean threeDaysPassed;
    private Boolean rejected;
    @Column(name = "id")
    private Long userId;
    @Column(name = "room_id")
    private Long roomId;

    @Builder
    public Plan(Long planId, LocalDate startDate, LocalDate targetDate,
                Float score, Integer week, Boolean threeDaysPassed,
                Boolean rejected, Long userId, Long roomId) {
        this.planId = planId;
        this.startDate = startDate;
        this.targetDate = targetDate;
        this.score = score;
        this.week = week;
        this.threeDaysPassed = threeDaysPassed;
        this.rejected = rejected;
        this.userId = userId;
        this.roomId = roomId;
    }
}
