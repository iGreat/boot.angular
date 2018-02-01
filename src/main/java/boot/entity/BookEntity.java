package boot.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_book")
public class BookEntity {
    private Long id;
    private String bookName;
    private ScoreEntity score;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @OneToOne(mappedBy = "book")
    public ScoreEntity getScore() {
        return score;
    }

    public void setScore(ScoreEntity score) {
        this.score = score;
    }
}
