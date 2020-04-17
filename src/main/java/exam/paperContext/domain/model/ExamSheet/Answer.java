package exam.paperContext.domain.model.ExamSheet;

import exam.paperContext.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
public class Answer implements ValueObject<Answer> {
    private int index;
    private String content;

    @Override
    public boolean sameValueAs(Answer other) {
        return other != null && index == other.index && content.equals(other.content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;
        Answer answer = (Answer) o;
        return index == answer.index &&
                Objects.equals(content, answer.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, content);
    }
}
