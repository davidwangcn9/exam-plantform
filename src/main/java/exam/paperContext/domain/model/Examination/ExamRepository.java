package exam.paperContext.domain.model.Examination;

import java.util.UUID;

public interface ExamRepository {
    Examination find(UUID id);

    void save(Examination examination);
}
