package exam.paperContext.domain.model.ExamSheet;

import exam.paperContext.domain.model.Examination.Examination;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class ExamSheet {
    private UUID examSheetId;
    private Examination examination;
    private int timeLeft = 120;
    private Student student;
    private Set<Answer> answers = new HashSet<>();
    private ExamSheetStatus status = ExamSheetStatus.STARTED;
    @Getter
    private Timer timer = new Timer();

    private ExamSheet(Examination examination, Student student, int timeLeft) {
        this.examination = examination;
        this.student = student;
        this.timeLeft = timeLeft;
    }

    static public ExamSheet assignExamSheet(Examination examination, Student student, int timeLeft) {
        ExamSheet examSheet = new ExamSheet(examination, student, timeLeft);
        examSheet.getTimer().schedule(examSheet.getTimerTask(), 1000);
        return examSheet;
    }

    public TimerTask getTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    --timeLeft;
                } else {
                    status = ExamSheetStatus.HANDEDIN;
                }
            }
        };
    }


    public void submitExamSheet(int index, String answer) {
        if (status == ExamSheetStatus.STARTED) {
            answers.add(new Answer(index, answer));
        }
    }

    public void handinExamSheet() {
        status = ExamSheetStatus.HANDEDIN;
    }


}
