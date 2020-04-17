package exam.paperContext.domain.model.Examination;

public class UnqualifiedExaminationException extends IllegalArgumentException {
    public UnqualifiedExaminationException(String message) {
        super(message);
    }

    public UnqualifiedExaminationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
