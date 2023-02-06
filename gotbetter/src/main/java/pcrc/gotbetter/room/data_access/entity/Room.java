package pcrc.gotbetter.room.data_access.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.util.Date;

@Entity
@Table(name = "Room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;
    private String title;
    @Column(name = "max_user_num")
    private Integer maxUserNum;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "target_date")
    private Date targetDate;
    @Column(name = "entry_fee")
    private Integer entryFee;
    @Column(name = "room_code")
    private String roomCode;
    @Column(name = "leader_id")
    private Long leaderId;
    private String account;
    @Column(name = "total_entry_fee")
    private Integer totalEntryFee;
    @Column(name = "rule_id")
    private Integer ruleId;

    @Builder
    public Room(Long roomId, String title, Integer maxUserNum,
                Date startDate, Date targetDate, Integer entryFee,
                String roomCode, Long leaderId, String account,
                Integer totalEntryFee, Integer ruleId) {
        this.roomId = roomId;
        this.title = title;
        this.maxUserNum = maxUserNum;
        this.startDate = startDate;
        this.targetDate = targetDate;
        this.entryFee = entryFee;
        this.roomCode = roomCode;
        this.leaderId = leaderId;
        this.account = account;
        this.totalEntryFee = totalEntryFee;
        this.ruleId = ruleId;
    }
}