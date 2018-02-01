package boot.entity;

import boot.common.ScoreLevel;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "t_score")
public class ScoreEntity {
    private UUID id;
    private float result;
    private ScoreLevel level;
    private boolean bPassing;
    private StudentEntity student;
    private CourseEntity course;
    private BookEntity book;

    @Id
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public ScoreLevel getLevel() {
        return level;
    }

    public void setLevel(ScoreLevel level) {
        this.level = level;
    }

    public boolean isbPassing() {
        return bPassing;
    }

    public void setbPassing(boolean bPassing) {
        this.bPassing = bPassing;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "fk_student_id"))
    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "fk_course_id"))
    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    @OneToOne
    @JoinColumn(name = "book_id")
    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
