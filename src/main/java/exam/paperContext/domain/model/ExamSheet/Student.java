package exam.paperContext.domain.model.ExamSheet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
class Student {
    private UUID studentId;
    private int score;
    private int age;
    private String name;
    private String description;
}
