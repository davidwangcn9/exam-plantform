package exam.paperContext.domain.model.Examination;

import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.shared.Entity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Examination implements Entity<Examination> {
    private UUID examinationId;
    private Paper paper;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


    private Examination(Paper paper, LocalDateTime startDate, LocalDateTime endDate) {
        this.examinationId = UUID.randomUUID();
        this.paper = Paper.copy(paper);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static Examination createExamniation(Paper paper, LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate.isAfter(endDate)) {
            throw new UnqualifiedExaminationException(String.format("StartDate %s is after end date %s", startDate, endDate));
        }
        if (paper.getTotalScore() > 100) {
            throw new UnqualifiedExaminationException(String.format("Paper's total score is %s which is higher than 100", paper.getTotalScore()));
        }
        return new Examination(paper, startDate, endDate);
    }

    @Override
    public boolean sameIdentityAs(Examination other) {
        return examinationId == other.examinationId;
    }
}
