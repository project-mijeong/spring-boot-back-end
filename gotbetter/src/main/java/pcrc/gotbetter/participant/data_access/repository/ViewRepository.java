package pcrc.gotbetter.participant.data_access.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import pcrc.gotbetter.participant.data_access.view.EnteredView;
import pcrc.gotbetter.participant.data_access.view.TryEnterView;

import java.util.List;

import static pcrc.gotbetter.participant.data_access.view.QEnteredView.enteredView;
import static pcrc.gotbetter.participant.data_access.view.QTryEnterView.tryEnterView;

@Repository
public class ViewRepository {
    private final JPAQueryFactory queryFactory;

    public ViewRepository(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    public EnteredView enteredByParticipantId(Long participant_id) {
        return queryFactory
                .selectFrom(enteredView)
                .where(enteredView.participantId.eq(participant_id))
                .fetchFirst();
    }

    public EnteredView enteredByUserIdRoomId(Long user_id, Long room_id) {
        return queryFactory
                .selectFrom(enteredView)
                .where(enteredView.userId.eq(user_id),
                        enteredView.roomId.eq(room_id))
                .fetchFirst();
    }

    public List<EnteredView> enteredListByRoomId(Long room_id) {
        return queryFactory
                .selectFrom(enteredView)
                .where(enteredView.roomId.eq(room_id))
                .fetch();
    }

    public Boolean enteredExistByUserIdRoomId(Long user_id, Long room_id) {
        Integer exists =  queryFactory
                .selectOne()
                .from(enteredView)
                .where(enteredView.userId.eq(user_id),
                        enteredView.roomId.eq(room_id))
                .fetchFirst();
        return exists != null;
    }

    public TryEnterView tryEnterByUserIdRoomId(Long user_id, Long room_id, Boolean accepted) {
        return queryFactory
                .selectFrom(tryEnterView)
                .where(tryEnterViewEqUserId(user_id),
                        tryEnterViewEqRoomId(room_id),
                        tryEnterViewEqAccepted(accepted))
                .fetchFirst();
    }

    public List<TryEnterView> tryEnterListByUserIdRoomId(Long user_id, Long room_id, Boolean accepted) {
        return queryFactory
                .selectFrom(tryEnterView)
                .where(tryEnterViewEqUserId(user_id),
                        tryEnterViewEqRoomId(room_id),
                        tryEnterViewEqAccepted(accepted))
                .fetch();
    }

    /**
     * try-enter view eq
     */
    private BooleanExpression tryEnterViewEqUserId(Long user_id) {
        return user_id == null ? null : tryEnterView.tryEnterId.userId.eq(user_id);
    }
    private BooleanExpression tryEnterViewEqRoomId(Long room_id) {
        return room_id == null ? null : tryEnterView.tryEnterId.roomId.eq(room_id);
    }
    private BooleanExpression tryEnterViewEqAccepted(Boolean accepted) {
        return accepted == null ? null : tryEnterView.accepted.eq(accepted);
    }
}
