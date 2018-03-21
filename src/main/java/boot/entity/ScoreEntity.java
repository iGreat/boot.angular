package boot.entity;

import boot.common.enums.ScoreLevel;

import javax.persistence.*;

@Entity
@Table(name = "t_score")
public class ScoreEntity {
    private Long id;
    private float result;
    private ScoreLevel level;
    private boolean bPassing;
    private StudentEntity student;
    private CourseEntity course;
    private BookEntity book;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
